import java.util.Arrays;

public class Tester1 {

    public static void main(String[] args){
        String to_test = "1234567891";
        StringBuilder sb = new StringBuilder("");

        char[] charArray = to_test.toCharArray();

        int period = 3;

        for (int j=0;j<period;j++){
            for (int i=j;i<charArray.length;i+=period){
                sb.append(charArray[i]);
            }
            sb.append(";");
        }
        System.out.println(sb);
    }
}