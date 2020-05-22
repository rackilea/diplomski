package com.ggl.testing;

public class RainWater implements Runnable {

    public static void main(String[] args) {
        new RainWater().run();
    }

    @Override
    public void run() {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int h = 0, sum = 0, i = 0, j = height.length - 1;

        while (i < j) {
            System.out.print(height[i] + "," + i + "   " + height[j] + "," + j
                    + "   ");

            if (height[i] < height[j]) {
                h = Math.max(h, height[i]);
                sum += h - height[i];
                i++;
            } else {
                h = Math.max(h, height[j]);
                sum += h - height[j];
                j--;
            }

            System.out.println(h + "   " + sum);
        }

        return sum;
    }

}