package fileio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadingFiles {
String g;
String a;
String t;
String al;
String d;
ArrayList<ReadingFiles> pList = new ArrayList<ReadingFiles>();

public ReadingFiles(){

}

public ReadingFiles(String[] ar){
    this(ar[0], ar[1], ar[2], ar[3], ar[4]);
}

public ReadingFiles (String genre, String artist, String title, String album, String date){
    g = genre;
    a = artist;
    t = title;
    al = album;
    d = date;
}

public void addData(ReadingFiles file){
    pList.add(file);
}

public void deserializeFile(){
    try{
        BufferedReader br = new BufferedReader(new FileReader("/Users/droy/var/musicplist.txt"));
        String line = null; 
        while ((line = br.readLine()) != null) {
            String ar[] = line.split(",");
            addData(new ReadingFiles(ar));
        }
    }
    catch (Exception ex){
        ex.printStackTrace();
    }
}


public static void main(String[] args) {
    ReadingFiles file = new ReadingFiles();
    file.deserializeFile();
}
}