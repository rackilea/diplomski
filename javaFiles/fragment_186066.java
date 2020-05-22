public class Main {

    public static String nestedReplace(String s) {
        int nested =0,i=0;
        StringBuilder o = new StringBuilder();
        while(i<s.length())
        {
            if(nested==0 && s.regionMatches(i,"[yes]",0,4))
            {
                o.append("Yes");
                i += 5;
                continue;
            }
            else if(s.charAt(i) == '[')
                nested++;
            else if(s.charAt(i) == ']')
                nested--;
            o.append(s.charAt(i));
            i++;
        }
        return new String(o);
    }

    public static void main(String[] args) {
        System.out.println(nestedReplace("input [yes] [yes] [yes] [mk:[yes] [yes] [yes]] [yes] [iif:[yes] [yes] [yes]]"));
    }
}