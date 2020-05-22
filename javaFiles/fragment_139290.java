package vlc.player;
import java.io.*;
public class vlc {
public static void main(String[] args) 
throws IOException, InterruptedException 
{
String [] s= new String[] 
{"C:\\Program Files\\VideoLAN\\VLC\\vlc.exe","D:\\Video\\3G\\K.MP4"};  
Runtime.getRuntime().exec(s); 
System.out.println("VLC started."+"prashant.ibmce@gmail.com");
}
}