package code.java.test;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> explode(String s, char d)
    {
       List<String> ret = new ArrayList<String>();
       int beginIndex =0;
       int endIndex = 0;
       while((endIndex = s.indexOf(d, beginIndex)) != -1){
           ret.add(s.substring(beginIndex, endIndex).trim());
           beginIndex = endIndex+1;
       }
       ret.add(s.substring(beginIndex, s.length()));
       return ret;

    }

    public static void main(String[] args)
    {
        String s = "superior sanguine bears";
        char d = 's';
        List<String> answer = explode(s, d);

        System.out.println(answer.toString());
    }
}