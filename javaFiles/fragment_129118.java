package com.example.katsar0v.myapplication;
import android.util.Log; 
/**
* Created by Katsar0v on 1/21/2015.
*/
public class SampleThread implements Runnable 
{
public interface TextViewChangeListener
{
    public void onTextViewChanged(Message msg);
}

public SampleThread(TextViewChangeListener mListener)
{
    this.mListener = mListener;
}

TextViewChangeListener mListener;

@Override
public void run() {
    int two = 0;
    while(two<10) {
        two++;
        try {
            Thread.sleep(1000);
            mListener.onTextViewChanged(String.valueOf(two + "sec"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
}