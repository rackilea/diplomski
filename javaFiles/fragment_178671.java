package com.example.testapp;

import java.io.BufferedReader;

public class getData{ 

    private static getData _instance; 


    public String myArray[] = new String[10]; //Array set up


    public static getData getMyData() //This is what the fragment calls to get the array.
    {
        if(_instance == null)
            _instance = new getData();
            _instance.runData();

        return _instance;
    }

    private void runData(){       
           this.myArray[0] = "test"; //Array given value

    }
}