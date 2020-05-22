import java.io.*;
import java.util.*;
public class Test{
    static String[] list;

    public static void name(){

       list= new String[]{"a","b"};
    }

    public static void main(String args[]){
         name();
        System.out.println(Arrays.toString(list));
    }
}