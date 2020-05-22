import java.util.*;
import java.lang.*;
import java.io.*;

class YourClass
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String str = "#114.034407,E,22.648272,N,0.00,0.00#010104#004500#17.034407,E,22.648272,N,0.00,0.00#010104#004500#5.034407,E,22.648272,N,0.00,0.00#010104#004500";
        String delimiters = "(?=#\\d{1,3}\\.)";

        String[] coordinates = str.split(delimiters);
        for(String coordinate : coordinates) {
            System.out.println(coordinate);
        } 
    }
}