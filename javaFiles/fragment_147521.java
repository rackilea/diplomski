import java.util.ArrayList;
import java.util.regex.Pattern;    
import java.util.regex.Matcher;

public class main {
    public static void main(String[] args) {
        String text = "helloWor4712389062l648977135536d 239012390oife234923 uiwed wq12893129038";

        ArrayList<String> result = getPossiblePANs(text);
        for(String pan : result) {
            System.out.print("Possible PAN: " + pan);
            if(luhnCheck(pan))
                System.out.println(" is valid!");
            else
                System.out.println(" is INVALID!");
        }
    }


    static ArrayList<String> getPossiblePANs(String text){  //Numbers w. 8-19 digits
        ArrayList<String> res = new ArrayList<>();
        Pattern p = Pattern.compile("\\d{8,19}+");
        Matcher m = p.matcher(text);
        while(m.find())
            res.add(m.group());
        return res;
    }

    static boolean luhnCheck(String cardNumber){
        if(cardNumber.length() < 8 || cardNumber.length() > 19)
            return false;
        int sum = 0;
        int begin = cardNumber.length() - 2;
        for(int i = begin; i >= 0; i-=2){
            int number = Integer.parseInt(cardNumber.substring(i, i+1)) * 2;
            if(number > 9) sum += (number - 9);
            else sum += number;
        }
        return (sum % 10) == 0;
    }
}