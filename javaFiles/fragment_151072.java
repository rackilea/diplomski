public class Test {

    public static void main(String[] args) 
    {
        String str = "node: { title: \"0\" label: \"sub_401000\" color: 76 textcolor: 73 bordercolor: black }";
        //String regex = ".*title: \"(.*)\".*label: \"(.*)\""; better regex below suggested by pschemo
        String regex = "title: \"([^\"]*)\".*label: \"([^\"]*)\"";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        if(m.find())
        {
            String title = m.group(1);
            String label = m.group(2);
            System.out.println(title);
            System.out.println(label);
        }
    }
}