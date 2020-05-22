package de.steamnet.loggingUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class BinaryAppender extends AppenderSkeleton {

    FileOutputStream fout;

    public BinaryAppender() throws FileNotFoundException {
        fout = new FileOutputStream("/tmp/somefile.log.bin");
    }

    @Override
    protected void append(LoggingEvent le) {
        String origMessage = le.getLoggerName() + " said: " + le.getMessage();
        byte[] obscure = origMessage.getBytes();
        for(int ii = 0; ii < obscure.length; ii++) {
            if(obscure[ii] == Byte.MAX_VALUE) {
                obscure[ii] = Byte.MIN_VALUE;
            } else {
                obscure[ii] = (byte)(obscure[ii] +1); // thats a really bad idea to create 'nonesense stuff' that way!
            }
        }
        try {
            fout.write(obscure);
        } catch (IOException ex) {
            System.out.println("too bad. File writer bombed.");
        }
    }

    @Override
    public boolean requiresLayout() {
        return false; // we do all layouting in here.
    }

    @Override
    public void close() {
        try {
            fout.close();
        } catch (IOException ex) {
            System.out.println("too bad. could not close it.");
        }
    }

}