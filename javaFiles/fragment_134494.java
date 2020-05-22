public class RoundParser {

    public static String parseRound(String text) {

        text = text.toUpperCase();

        String result;

        char[] ch = text.toCharArray();

     int count=0,pos=0;
        int c[10];
        for(int i=0;i<ch.length;i++){

        if(ch[i].equals("(")){
        count++;  
         if(ch[i-1].equals("D")){
              c[pos]=count;   //will store the count value at every opening round
                  pos++;
              }
        }

        if(ch[i].equals(")")){
        count--;
         for(int j=0;j<10;j++){
             if(c[j]==count)   //if the closing of round had been encountered
                   ch[i]="#";   
         }
       }

        }


        text = String.valueOf(ch);

        result = text;
        return result;
    }

    public static void main(String[] args) {
        String text = "=ROUND(IF(AND($BY18=2);CA18*CB18/$M$11;IF($BY18=3;CA18*CB18/$M$10;IF($BY18=4;ROUND(CA18*CB18;$M$10)/$M$9;CA18*CB18)))/$M$12;$M$11)";

        System.out.println(parseRound(text));
    }

}