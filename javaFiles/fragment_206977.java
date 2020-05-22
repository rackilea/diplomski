public class Main {


static String query = "This is a URL http://facebook.com"
                + " and this is another, http://twitter.com "
                + "this is the last URL http://instagram.com"
                + " all these URLs should be printed after the code execution";
public static void main(String args[]) {
        String pattern = "(http:[/][/][Ww.]*[a-zA-Z]+.com)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(query);

        while(m.find())
        {
            System.out.println(m.group(1));
        }
}

}