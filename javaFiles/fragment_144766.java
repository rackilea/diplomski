import java.lang.String;
import java.util.*;

class CountVowels{
    static int countVowelA=0,countVowelE=0,countVowelI=0,countVowelO=0,countVowelU=0,countConsonants=0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str="";
        System.out.println("Please enter the string : ");
        str = sc.nextLine().trim();
        System.out.println();
        countVowels(str);
        printVowelsCount();
    }

    public static void countVowels(String str){
        char ch;
        for(int i = 0; i<str.length(); i ++){
            ch = str.charAt(i);
            if(ch == 'a' || ch =='A') {
                countVowelA++;
            } else if(ch == 'e' || ch =='E') {
                countVowelE++;
            } else if(ch == 'i' || ch =='I') {
                countVowelI++;
            } else if(ch == 'o' || ch =='O') {
                countVowelO++;
            } else if(ch == 'u' || ch =='U') {
                countVowelU++;
            } else if(Character.isLetter(ch)){
                countConsonants++;
            }
        }
    }

    public static void printVowelsCount(){
        System.out.println("Occurances of A in given string  : " +countVowelA);
        System.out.println("Occurances of E in given string  : " +countVowelE);
        System.out.println("Occurances of I in given string  : " +countVowelI);
        System.out.println("Occurances of O in given string  : " +countVowelO);
        System.out.println("Occurances of U in given string  : " +countVowelU);
        System.out.println("Number of vowels in strings are  : " +(countVowelA+countVowelE+countVowelI+countVowelO+countVowelU));
        System.out.println("Number of Consonants : " +countConsonants);
    }
}