package com.example.a.sitetool;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class RpiUpdate {
    private static boolean success;


    public static void update() {
        //TODO add online version checking and download
        if (success)
            uploadFile();

    }

    private static void uploadFile() {
        Log.d("RPIUpdate", "Entered upload File");
        success=false;
        new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... params) {
                try {
                    executeRemoteCommand("pi", "rbs", "192.168.4.1", 22);
                    Log.d("MainActivity", "File Uploaded");
                    success = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("MainActivity", "Failed to upload file");
                    success = false;
                }
                return null;
            }
        }.execute(1);
    }


public static void executeRemoteCommand(final String username, final String password, final String hostname, final int port)
            throws Exception {
        Log.d("RPiUpdate", "Entered executeRemoteCommand");

        //Creating the path on android to bbserver.py
        File root;
        root = new File(Environment.getExternalStorageDirectory() + File.separator + "Download");
        if (!root.exists()) {
            root.mkdirs();
        }
        File file = new File(root, "bbserver.py");

        JSch jsch = new JSch();
        Session session = jsch.getSession(username, hostname, port);
        session.setPassword(password);

        // Avoid asking for key confirmation
        Properties prop = new Properties();
        prop.put("StrictHostKeyChecking", "no");
        session.setConfig(prop);

        session.connect();

        //SFTP setup
        Channel channel = session.openChannel("sftp");
        channel.connect();

        ChannelSftp channelsftp = (ChannelSftp) channel;
        //Renaming the old bbserver.py
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy:MM:dd:HH:mm", Locale.ENGLISH);
        Date now = new Date();
        channelsftp.cd("/home/pi/Desktop");
        // 384 in octal is 600. This makes the file non executable. only readable and writable

        channelsftp.chmod(384, "/home/pi/Desktop/bbserver.py");

        channelsftp.rename("/home/pi/Desktop/bbserver.py", "/home/pi/Desktop/bbserver" + formatter.format(now) + ".py");

        //sending the new bbserver.py file
        channelsftp.put(new FileInputStream(file), file.getName());
        Log.d("RPiUpdate", "Sent file");

        //511 in octal is 777. This gives the file all available permissions(read, write, execute). thus making the file an executable

        channelsftp.chmod(511, "/home/pi/Desktop/" + file.getName());
        Log.d("RPiUpdate", "Changed permissions");

        channel.disconnect();

    }