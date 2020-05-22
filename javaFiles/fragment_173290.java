package net.snortum.play;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AdsPlay {
    public static void main(String[] args) {
        new AdsPlay().start();
    }

    private void start() {
        File file = new File("test.txt:hidden");
        try (BufferedReader bf = new BufferedReader( new FileReader(file))) {
            String hidden = bf.readLine();
            System.out.println(hidden);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}