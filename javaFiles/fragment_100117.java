package tests;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileScan {
    private ArrayList<String> stringArray;
    private ArrayList<Integer> numArray;
    private LoadingBox loadFile;
    private String files;

    public FileScan(){
        stringArray = new ArrayList<String>();
        numArray = new ArrayList<Integer>();
        loadFile = new LoadingBox();
        loadFile.loadIt();
        files = LoadFile.getFiles();
    }

    public void scan(String[] args) throws IOException {
        Scanner input = null;
        new FileScan();
        try {
            input = new Scanner(new File(files));
            //add strings and integers from file to different arrays
            while (input.hasNext()) {
                String token = input.nextLine();
                try{
                    int o = Integer.parseInt(token);
                    numArray.add(o);                        
                 }
                 catch(NumberFormatException nfe){           
                     stringArray.add(token);                         
                 }   
            }
        }   
        finally {
            if (input != null) {
                 input.close();
            }

    }
}