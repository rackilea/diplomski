import java.util.ArrayList;
import java.util.Scanner;

public class PrintSubstrings {

    public static void main(String[] args) {
        Scanner scn =new Scanner(System.in);
        String str=scn.nextLine();
        ArrayList<String>ans=printSub(str);
        for(int i=0;i<ans.size();i++)
        {
            System.out.print(ans.get(i)+" ");
        }
    }
    public static ArrayList<String> printSub(String str) {

        if(str.length()==0)return new ArrayList<String>();

        ArrayList<String> fx=printSub(str.substring(1));

        int size=fx.size();
        fx.add(Character.toString(str.charAt(0)));
        for(int i=0;i<size;i++)
        {
            fx.add(str.charAt(0)+fx.get(i));
        }
        return fx;
    }
}