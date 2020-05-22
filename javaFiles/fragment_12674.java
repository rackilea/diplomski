import java.util.Scanner;
public class Main {

    public static int checkvowels (String sentence)
    {
        int countvowels=0;
        int i;
        for (i=0;i<sentence.length();i++)
        {
            if ((sentence.charAt(i)=='a')||(sentence.charAt(i)=='e')||(sentence.charAt(i)=='i')||(sentence.charAt(i)=='o')
                    ||(sentence.charAt(i)=='u')|| (sentence.charAt(i)=='A')||(sentence.charAt(i)=='E')||(sentence.charAt(i)=='I')
                    ||(sentence.charAt(i)=='O')||(sentence.charAt(i)=='U'))
            {
                countvowels++;
            }
        }
        return countvowels;

    }
    public static Scanner reader= new Scanner(System.in);
    public static void main(String[]args)
    {
        int max=0;
        String maxvowels="";
        System.out.println("Insert a sentence");
        String sentence=reader.nextLine();
        while (!sentence.equals(""))
        {
            if (checkvowels(sentence)>max)
            {
                max=checkvowels(sentence);
                maxvowels=sentence;
            }
            System.out.println("Insert a sentence");
            sentence=reader.nextLine();
        }
        System.out.println(maxvowels);
    }
}