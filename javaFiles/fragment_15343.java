import java.util.StringTokenizer;



public class Complexity {
    public static void main(String[] args) {

        String input = "for(i=0;i<10;i++)\n{\nfor(i=0;i<10;i++)\n{\nfor(i=0;i<10;i++)\n{\n}\n}\n}\nfor(i=0;i<10;i++)\n{\n}\nfor(i=0;i<10;i++)\n{\nfor(i=0;i<10;i++)\n{\n}\n}";
        int open_bracket=0;
        StringTokenizer t = new StringTokenizer(input);
        String result = "";

        String token="";
        int current = 0;

        System.out.println("CODE \n"+input);

        while(t.hasMoreTokens())
        {

            token = t.nextToken();

            if(token.equals("{")) open_bracket++;

            if(token.equals("}")) open_bracket--;

            if(token.length()>=3) if(token.substring(0, 3).equals("for"))  current++;

            if(open_bracket==0&&token.equals("}"))
            {
                result += " n^"+current+" +";
                current = 0;
            }
        }

        if(result.length()>0) result = result.substring(0, result.length()-1);

        result = "O( "+result+")";

        System.out.println("RESULT = "+result);

    }
}