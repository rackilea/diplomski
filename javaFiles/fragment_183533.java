import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;

public class testSmb {

    static boolean append = true;
    static int threadCount = 0;

    static int bufferSize = 2048;

    static NtlmPasswordAuthentication auth;

    static File localFile;

    static SmbFile primarySmbFile;
    static BufferedInputStream input;
    static SmbFileOutputStream output;

    static SmbFile secondary1SmbFile;
    static BufferedInputStream sec1Input;
    static SmbFileOutputStream sec1Output;

    static SmbFile secondary2SmbFile;
    static BufferedInputStream sec2Input;
    static SmbFileOutputStream sec2Output;

    static SmbFile secondary3SmbFile;
    static BufferedInputStream sec3Input;
    static SmbFileOutputStream sec3Output;

    public static Object lock = new Object();

    public static void main(String... args) throws IOException {
        System.out.println("Main thread Started");
        init();
        write(input, output);
        writeInThread(sec1Input, sec1Output);
        writeInThread(sec2Input, sec2Output);
        writeInThread(sec3Input, sec3Output);

        System.out.println("Main thread Finished");
    }

    public static void init() throws MalformedURLException,
            FileNotFoundException, SmbException, UnknownHostException {

        localFile = new File("c:\\temp\\myFile.txt");
        if (localFile.length() > 20971520l) {
            bufferSize = 131072;
        }

        String server = "myServer";
        String username = "myUser";
        String password = "myPass";
        String path = "myPath";
        auth = new NtlmPasswordAuthentication(server, username, password);

        input = new BufferedInputStream(new FileInputStream(localFile));
        primarySmbFile = new SmbFile("smb://" + server + "/" + path
                + "/primary.txt", auth, SmbFile.FILE_SHARE_READ
                | SmbFile.FILE_SHARE_WRITE | SmbFile.FILE_SHARE_DELETE);
        output = new SmbFileOutputStream(primarySmbFile, append);
        if (!primarySmbFile.exists()) {
            primarySmbFile.createNewFile();
        }

        sec1Input = new BufferedInputStream(new SmbFileInputStream(new SmbFile(
                primarySmbFile, primarySmbFile.getName())));
        secondary1SmbFile = new SmbFile("smb://" + server + "/" + path
                + "/secondary1.txt", auth, SmbFile.FILE_SHARE_READ
                | SmbFile.FILE_SHARE_WRITE | SmbFile.FILE_SHARE_DELETE);
        sec1Output = new SmbFileOutputStream(secondary1SmbFile, append);
        if (!secondary1SmbFile.exists()) {
            secondary1SmbFile.createNewFile();
        }

        sec2Input = new BufferedInputStream(new SmbFileInputStream(new SmbFile(
                primarySmbFile, primarySmbFile.getName())));
        secondary2SmbFile = new SmbFile("smb://" + server + "/" + path
                + "/secondary2.txt", auth, SmbFile.FILE_SHARE_READ
                | SmbFile.FILE_SHARE_WRITE | SmbFile.FILE_SHARE_DELETE);
        sec2Output = new SmbFileOutputStream(secondary2SmbFile, append);
        if (!secondary2SmbFile.exists()) {
            secondary2SmbFile.createNewFile();
        }

        sec3Input = new BufferedInputStream(new SmbFileInputStream(new SmbFile(
                primarySmbFile, primarySmbFile.getName())));
        secondary3SmbFile = new SmbFile("smb://" + server + "/" + path
                + "/secondary3.txt", auth, SmbFile.FILE_SHARE_READ
                | SmbFile.FILE_SHARE_WRITE | SmbFile.FILE_SHARE_DELETE);
        sec3Output = new SmbFileOutputStream(secondary3SmbFile, append);
        if (!secondary3SmbFile.exists()) {
            secondary3SmbFile.createNewFile();
        }

    }

    public static void write(BufferedInputStream bufferedInputStream,
            SmbFileOutputStream smbFileOutputStream) throws IOException {

        byte[] buffer = new byte[bufferSize];
        int len = 0;

        try {

            while ((len = bufferedInputStream.read(buffer)) > 0) {
                synchronized (lock) {
                    System.out.println("'" + Thread.currentThread().getName()
                            + "' writing " + bufferSize + "bytes");
                    smbFileOutputStream.write(buffer, 0, len);
                    smbFileOutputStream.flush();
                }
            }

        } catch (IOException e) {
            throw e;
        } finally {
            try {
                bufferedInputStream.close();
            } catch (Exception e) {
            }

            try {
                smbFileOutputStream.flush();
                smbFileOutputStream.close();
            } catch (Exception e) {
            }
        }

    }

    public static void writeInThread(
            final BufferedInputStream bufferedInputStream,
            final SmbFileOutputStream smbFileOutputStream) {
        threadCount++;

        new Thread("Secondary thread " + threadCount) {
            public void run() {
                System.out.println(Thread.currentThread().getName()
                        + ": started");
                try {
                    write(bufferedInputStream, smbFileOutputStream);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        + ": finished");
            }
        }.start();

    }
}