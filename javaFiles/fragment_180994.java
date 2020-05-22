import java.util.regex.*;

class A {
        public static void main(String[] args) {
                String s = "this is a good example with 234 songs";


                Pattern p = Pattern.compile("this is a (.*?) example with (\\d+) songs");
                Matcher m = p.matcher(s);
                if (m.matches()) {
                        String kind = m.group(1);
                        String nbr = m.group(2);

                        System.out.println("kind: " + kind + " nbr: " + nbr);
                }
        }
}