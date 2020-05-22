import java.util.HashMap;

import java.util.Scanner;

public class Letters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The Sentense");
        String s = in.nextLine();
        HashMap<Character,Integer> w = new HashMap<Character,Integer>();
        for(int i=0; i < s.length(); i++){
            w.put(s.charAt(i), w.get(s.charAt(i))==null?1:(w.get(s.charAt(i))+1));
        }
        for(char i:w.keySet()){
            System.out.println(i+":"+w.get(i));
        }
    }
}