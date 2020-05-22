package jfd;

public class BoyGirlCounter {

    public static void main(String[] args) {
        countBoyGirlInts("JP 3 Helene 7 Jordan 14 Iva 13 Sergey 4 Marianne 9 Kenneth 6");
    }

    public static void countBoyGirlInts(String boysgirls) {
        String[] words = boysgirls.split(" ");

        int boypos = 1;
        int boycount = 0;
        int boysum = 0;

        int girlpos = 3;        
        int girlcount = 0;      
        int girlsum = 0;

        for (int i = 0; i < words.length; i++) {
            if (i == boypos) {
                boycount++;
                boysum += Integer.valueOf(words[i]).intValue();
                boypos += 4;
            }
            if (i == girlpos) {
                girlcount++;
                girlsum += Integer.valueOf(words[i]).intValue();
                girlpos += 4;
            }
        }

        System.out.println(boycount + " boys, " + girlcount + " girls");
        System.out.println("Boys sum = " + boysum);
        System.out.println("Girls sum = " + girlsum);

    }
}