import java.util.regex.*;

public class HelloWorld {
    public static void main(String []args){
        String test = "INSERT INTO table_name (c1,c2,c3) VALUES (abc,def,ghi) , (jkl,mno,pqr)";

        String regex = "((?<=(INSERT\\sINTO\\s))[\\w\\d_]+(?=\\s+))|((?<=\\()([\\w\\d_,]+)+(?=\\)))";

        Pattern re = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher m = re.matcher(test);
        while (m.find()) {
            System.out.println(m.group(0));
        }
     }
}