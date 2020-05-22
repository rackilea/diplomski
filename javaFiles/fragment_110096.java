import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner Input= new Scanner(System.in);
        System.out.print("Enter String: ");
        String s =Input.nextLine();
        if(vowels(s)) System.out.println("It contains a vowel!");
        else System.out.println("It does not!");
    }
    public static boolean vowels(String s){
        String word = s.toUpperCase();
        char[] words = word.toCharArray();
        for(int i = 0; i<words.length; i++){
            char z = words[i];
            if (z=='A'||z=='E'||z=='I'||z=='O'||z=='U') return true;
        }
        return false;
    }

}