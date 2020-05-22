import java.util.regex.*;

class test
{
    public static void main(String args[])
    {
        Pattern pattern=Pattern.compile("^process_(client_|abc_pqr_client_)(.*)$");
        Matcher matcher = pattern.matcher("process_client_123_Tree");
        while(matcher.find())
            System.out.println("String 1 Group 2: "+matcher.group(2));
        matcher = pattern.matcher("process_abc_pqr_client_123_Tree");
        while(matcher.find())
            System.out.println("String 2 Group 2: "+matcher.group(2));

        System.out.println("Another way..");

        System.out.println("String 1 Group 2: "+"process_client_123_Tree".replace("process_client_", ""));
        System.out.println("String 2 Group 2: "+"process_abc_pqr_client_123_Tree".replace("process_abc_pqr_client_", ""));
    }
}