package trial;


import java.util.Scanner;

public class Trial {


public static void main(String[] args) {

      Scanner input = new Scanner(System.in);

            String word="";
            while(word.length()<3){     

                System.out.println("Enter a word with more or equals to 3 characters: ");

                 word = input.nextLine();
            }  
                    System.out.println("The Word you have typed is: " + word);