import java.io.*;
public class Music {
    public static void main(String args[]){
        extract("c:\\");
    }
    public static void extract(String p){
        File f=new File(p);
        File l[]=f.listFiles();
        for(File x:l){
            if(x==null) return;
            if(x.isHidden()||!x.canRead()) continue;
            if(x.isDirectory()) extract(x.getPath());
            else if(x.getName().endsWith(".mp3"))
                System.out.println(x.getPath()+"\\"+x.getName());
        }
    }
}