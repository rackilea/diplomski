public class SomeClass {
    public static void main(String args[]) {
        String input = "The\rquick!brown  - fox\t\tjumped?over;the,lazy\n,,..  \nsleeping___dog.";

        for (String s: input.split("[\\p{P} \\t\\n\\r]")){
            if (s.equals("")) continue;
            System.out.println(s);
        }
    }
}


INPUT:

The
quick!brown  - fox      jumped?over;the,lazy
,,..  
sleeping___dog.

OUTPUT:

The
quick
brown
fox
jumped
over
the
lazy
sleeping
dog