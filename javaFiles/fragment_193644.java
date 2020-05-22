package com.MyApp;

public class OrientationChanger
{
    public static int change(int n)
    {
        switch(n)
        {
               case 0:
                   setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                   break;
               case 1:
                   setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                   break;                   
           }
    }
}