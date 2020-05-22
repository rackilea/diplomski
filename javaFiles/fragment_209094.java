package com.hk.basicjava.clasload.tests2;

import java.io.File;
import java.util.Date;


class MyFile extends File {

    private long time = 0; 

    public MyFile(String name, long timeMills) {
        super(name);
        time = timeMills;
    }
    @Override
    public long lastModified() {
        return time;
    }
}

public class Files {

    /**
     * @param args
     */
    public static void main(String[] args) {

        File[] files = new File[5]; 
        files[0] = new MyFile("File1", new Date(2013,1,15, 7,0).getTime());
        files[1] = new MyFile("File2", new Date(2013,1,15, 7,40).getTime());
        files[2] = new MyFile("File3", new Date(2013,1,15, 5,0).getTime());
        files[3] = new MyFile("File4", new Date(2013,1,15, 10,0).getTime());
        files[4] = new MyFile("File5", new Date(2013,1,15, 4,0).getTime());
        sortFilesDesc(files);
    }

    public static void sortFilesDesc(File[] files) {        
        File firstMostRecent = null;
        File secondMostRecent = null;
        File thirdMostRecent = null;
        for (File file : files) {
            if ((firstMostRecent == null)
                    || (firstMostRecent.lastModified() < file.lastModified())) {
                thirdMostRecent = secondMostRecent;
                secondMostRecent = firstMostRecent;             
                firstMostRecent = file;
            } else if ((secondMostRecent == null)
                    || (secondMostRecent.lastModified() < file.lastModified())) {
                thirdMostRecent = secondMostRecent;
                secondMostRecent = file;
            } else if ((thirdMostRecent == null)
                    || (thirdMostRecent.lastModified() < file.lastModified())) {
                thirdMostRecent = file;
            }
        }
        System.out.println("firstMostRecent : " + firstMostRecent.getName());
        System.out.println("secondMostRecent : " + secondMostRecent.getName());
        System.out.println("thirdMostRecent : " + thirdMostRecent.getName());
    } 

}