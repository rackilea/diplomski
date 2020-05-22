package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multithreader {

    /**
     * Needs to be volatile because the two thread communicate through it.
     * It is also very important that boolean updates and lookups are atomic,
     * we cannot do the same with for example a long!
     */
    volatile static boolean shouldFilePrinterPrint = false;

    public static void main(String[] args) throws IOException {

        // needs to be final so that the filePrinter can see it
        final BufferedReader br = new BufferedReader(new FileReader(new File("file.txt")));

        // this is the task of printing 5 lines from a file whenever shouldFilePrinterPrint is true
        Runnable filePrinter = new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(shouldFilePrinterPrint){
                        shouldFilePrinterPrint=false;
                        String line;
                        int counter = 0;
                        try {
                            while (counter<5 && (line = br.readLine()) != null) {
                                counter++;
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        // this is the task that will set shouldFilePrinterPrint to true every time we push enter
        Runnable inputAwaiter = new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        System.in.read();
                        shouldFilePrinterPrint=true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        };

        // we use the executor service to launch the two tasks in two threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(filePrinter);
        executorService.execute(inputAwaiter);

        // I am omitting cleanup such as closing the reader, shutting down the executor service, etc.
        // and am just leaving the program to never terminate until manually stopped,
        // but such cleanup is very important in a real program!
    }
}