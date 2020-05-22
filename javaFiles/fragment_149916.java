package com.ggl.testing;

import java.util.Arrays;

public class BitShifting {

    public static void main(String[] args) {
        BitShifting bitShifting = new BitShifting();

        int[] bits1 = { 1, 1, 0, 0, 1, 0, 1, 0 };
        shiftAndDisplay(bitShifting, bits1);
        int[] bits2 = { 1, 1, 0, 0, 0, 0, 1, 1 };
        shiftAndDisplay(bitShifting, bits2);
        int[] bits3 = { 0, 0, 0, 0, 0, 0, 1, 1 };
        shiftAndDisplay(bitShifting, bits3);
    }

    private static void shiftAndDisplay(BitShifting bitShifting, int[] bits) {
        int[] shifted = bitShifting.shiftLeft(bits);
        System.out.print(Arrays.toString(bits));
        System.out.print(" -> ");
        System.out.println(Arrays.toString(shifted));
    }

    public int[] shiftLeft(int[] bits) {
        int bit = bits[0];
        int length = bits.length - 1;
        int[] output = new int[bits.length];

        for (int i = 0; i < length; i++) {
            output[i] = bits[i + 1];
        }

        output[length] = bit;

        return output;
    }

}