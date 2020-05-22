package com.acme;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class SendAndReceive {

    public static void main(String[] args) throws IOException {
        int[] ints = new int[] {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE};

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        writeInts(out, ints);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        int[] results = readInts(in);

        if (!Arrays.equals(ints, results)) System.out.println("Damn!");
        else System.out.println("Aaall's well!");
    }

    private static void writeInts(OutputStream out, int[] ints) throws IOException {
        DataOutputStream dataOut = new DataOutputStream(out);
        dataOut.writeInt(ints.length);
        for (int e : ints) dataOut.writeInt(e);
        dataOut.flush();
    }

    private static int[] readInts(InputStream in) throws IOException {
        DataInputStream dataIn = new DataInputStream(in);
        int[] ints = new int[dataIn.readInt()];
        for (int i = 0; i < ints.length; ++i) ints[i] = dataIn.readInt();
        return ints;
    }
}