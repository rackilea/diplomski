import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zac
 */
public class Sorting extends Thread{
    private static final int MAGIC_PNG[] = new int[] { 0x89, 0x50, 0x4e, 0x47, 0x0d, 0x0a, 0x1a, 0x0a };
    private static final int MAGIC_JPG[] = new int[] { 0xFF, 0xD8, 0xFF };
    private static final int MAGIC_PDF[] = new int[] { 0x25, 0x50, 0x44, 0x46 };
    private static final int MAGIC_MP3[] = new int[] { 0x49, 0x44, 0x33 };
    private String stagingDirectory,targetDirectory,preferenceFileDir;
    private File thePrefs;
    public Sorting(){

        preferenceFileDir  = System.getProperty( "user.home" );
        thePrefs = new File(preferenceFileDir+"/Staging/prefs.txt");
    }

    private static boolean isPng(File filename) throws Exception {
        FileInputStream ins = new FileInputStream(filename);
        try {
            for(int i = 0; i < MAGIC_PNG.length; ++i) {
                if(ins.read() != MAGIC_PNG[i]) {
                    return false;
                }
            }
            return true;
        } finally {
            ins.close();
        }
    }
     private static boolean isJpg(File filename) throws Exception {
        FileInputStream ins = new FileInputStream(filename);
        try {
            for(int i = 0; i < MAGIC_JPG.length; ++i) {
                if(ins.read() != MAGIC_JPG[i]) {
                    return false;
                }
            }
            return true;
        } finally {
            ins.close();
        }
     }
     private static boolean isMp3(File filename) throws Exception {
         FileInputStream ins = new FileInputStream(filename);
        try {
            for(int i = 0; i < MAGIC_MP3.length; ++i) {
                if(ins.read() != MAGIC_MP3[i]) {
                    return false;
                }
            }
            return true;
        } finally {
            ins.close();
        }
     }
     private static boolean isPdf(File filename) throws Exception {
        FileInputStream ins = new FileInputStream(filename);
        try {
            for(int i = 0; i < MAGIC_PDF.length; ++i) {
                if(ins.read() != MAGIC_PDF[i]) {
                    return false;
                }
            }
            return true;
        } finally {
            ins.close();
        }
     }
     private void getPreference(){
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(thePrefs);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            stagingDirectory= br.readLine();
            targetDirectory = br.readLine();
        }
        catch(Exception e){

        }
     }
     public void run() {
         //System.out.print("in run \n");
         int len;
         getPreference();
         File stDir = new File(stagingDirectory);
         File[] listOfFiles = stDir.listFiles();
         //System.out.print(listOfFiles);
         if(listOfFiles == null)
             len =0;
         else
             len = listOfFiles.length;
        try{
           while(true){ 
               System.out.println(len);
            for(int i = 0;i<len;i++){
                if(isJpg(listOfFiles[i])){
                    System.out.println(listOfFiles[i].getName()+ " is jpeg");
                    listOfFiles[i].renameTo(new File(targetDirectory+"/jpeg/"+listOfFiles[i].getName()+".jpeg"));
                }
                else if(isPdf(listOfFiles[i])){
                    System.out.println(listOfFiles[i].getName()+ " is pdf");
                    listOfFiles[i].renameTo(new File(targetDirectory+"/pdf/"+listOfFiles[i].getName()+".pdf"));
                }
                else if(isMp3(listOfFiles[i])){
                    System.out.println(listOfFiles[i].getName()+ " is mp3");
                    listOfFiles[i].renameTo(new File(targetDirectory+"/mp3/"+listOfFiles[i].getName()+".mp3"));
                }
                else if(isPng(listOfFiles[i])){
                    System.out.println(listOfFiles[i].getName()+ " is png");
                    listOfFiles[i].renameTo(new File(targetDirectory+"/png/"+listOfFiles[i].getName()+".png"));
                }
            }
            listOfFiles = stDir.listFiles();
            len = listOfFiles.length;
            Thread.sleep(3000);//sleeps for 3 seconds
           }
        }catch(Exception e){
            System.out.println("interrupted"+e);
        }
     }
}