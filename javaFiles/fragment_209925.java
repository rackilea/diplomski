package com.me;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class Main extends Activity
{
    private static String FILE_NAME = "HIGHSCORES.txt"; // Added this for better maintainability
    private String myDir;
    private List<Integer> scores;


    @Override public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Folder in SD card
        myDir = Environment.getExternalStorageDirectory() + "/TwoDee"; // Just a random name

        // Initialize Integer list with some values
        scores = new ArrayList<Integer>();
        scores.add(new Integer(5));
        scores.add(new Integer(9));
        scores.add(new Integer(11));

        // Make sure there's the file or our test crashes. I hope you have similar code elsewhere?
        try
        {
            File folder = new File(Environment.getExternalStorageDirectory(), "TwoDee");
            if (folder.exists() == false)
                folder.mkdirs();

            File file = new File(folder, FILE_NAME);
            if (file.exists() == false)
                file.createNewFile();
        }
        catch (Exception e)
        {
            System.out.println("Fail"); // Blunt :)
        }
    }

    @Override public void onResume()
    {
        beforeSave();
        super.onResume();
    }

    @Override public void onPause()
    {
        save();
        super.onPause();
    }

    @Override public void onStop()
    {
        super.onStop();
    }

    public void save()
    {
        Log.v("TwoDee", "save...");
        try
        {
            BufferedWriter fw = new BufferedWriter(new FileWriter(myDir + "/" + FILE_NAME));
            for (Integer i : scores)
            {
                Log.v("TwoDee", i.toString());
                fw.write(i.toString());
                fw.newLine();
                //fw.flush(); // This is not really needed.
            }
            fw.close();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Log.v("TwoDee", "...save");
    }

    public void beforeSave()
    {
        //List<String> stringReader = new ArrayList<String>(); // Not needed...
        BufferedReader br = null;
        Log.v("TwoDee", "beforeSave...");
        try
        {
            br = new BufferedReader(new FileReader(myDir + "/" + FILE_NAME));
            String s = "";
            while ((s = br.readLine()) != null)
            {
                Log.v("TwoDee", s);
                //System.out.println("LINE: " + s + "\n"); // Not needed...
                scores.add(Integer.parseInt(s));
            }
        } catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Log.v("TwoDee", "...beforeSave");
    }
}