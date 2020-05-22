import java.io.*;
import java.util.*;
import java.lang.*;

public class xes{
    public static String convert(int n, int l){
        StringBuilder s = new StringBuilder();
        int g = 0;
        while(n>0){
            int c = n%2;
            if(c==0)
                s.append("0");
            else{
                s.append("1");
                g++;
            }
            n/=2;
        }
        while(s.length()<l)
            s.append("0");
        if(g%2 == 0)
            return ("" + s.reverse());
        else
            return "-1";
    }

    public static ArrayList<String> getAllPatterns(String s){
        int l = s.length();
        int p = (1<<l) - 1;            //because you don't want all x's, so -1. 1<<l is same as power(2,l)
        ArrayList<String> arr = new ArrayList<String>();
        for(int i=1;i<p;i++){        //i started from i=1 since you don't want all characters visible in any string in arraylist...if you want, stat it with 0
            String z = convert(i,l);
            if(z.equals("-1"))
                continue;
            StringBuilder g = new StringBuilder(s);
            for(int j=0; j < z.length(); j++){
                if(z.charAt(j)=='1')
                    g.setCharAt(j,'x');
            }
            System.out.println(g);
            arr.add("" + g);
        }
        return arr;
    }

    public static void main(String args[]){
        ArrayList<String> patterns = getAllPatterns("1823");
    }
}