import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        DecimalFormat decimalFormat = new DecimalFormat("#00.00");
        System.out.println(decimalFormat.format(0.99f));
        System.out.println(decimalFormat.format(9.99f));
        System.out.println(decimalFormat.format(19.99f));
        System.out.println(decimalFormat.format(119.99f));
    }
}