public class Apcsa2 {

    public static void main(String[] args) {
        String input="hello world I love dogs";

        String[] arryWords=input.split("\\s+");

        //Count-Number of words
        System.out.println("Count:"+arryWords.length);

        //Display each word separately
        for(String word:arryWords){
            System.out.println(word);
        }

    }
}