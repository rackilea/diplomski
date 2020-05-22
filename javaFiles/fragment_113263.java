package com.xxx.thread;

public class Updater implements Runnable{

    @Override
    public void run() {

        while(true) {
            try {
                //do work here
                Thread.sleep(1000*60*60); //sleep time in ms
            } catch (InterruptedException ex) {
            }
        }
    }



}