package main.application;

import java.io.File;
import java.io.IOException;

public class Main {

    private static int incrementFileName = 1;
    private static final String PATH = "C:\\Users\\user\\Desktop\\";

    public static void main(String[] args) throws IOException {

        //Each time the button is pressed.
        for (int c = 0; c < 5; c++)
        {
            incrementFileName++;
            buttonClicked();
        }
    }

    private static void buttonClicked() throws IOException
    {
        String Name = "TXT" + incrementFileName +".txt";
        File TXT = new File(PATH + Name);
        TXT.createNewFile();
    }
}