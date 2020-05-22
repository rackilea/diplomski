import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        String str = "-18+65-14+78";
        String temp = "0";
        double sum = 0.0;
        char prev = '+';
        for(char ch: str.toCharArray()) {
            if(ch == '+' || ch == '-') {
                if(prev == '+') sum = sum + Double.parseDouble(temp);
                else sum = sum - Double.parseDouble(temp);
                prev = ch;
                temp = "0";
            }
            else temp = temp + ch;
        }
        if(prev == '+') sum = sum + Double.parseDouble(temp);
        else sum = sum - Double.parseDouble(temp);

        System.out.println(sum);
    }
}