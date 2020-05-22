public static void main (String[] args) throws java.lang.Exception
{
    Scanner console = new Scanner(System.in);

    while (console.hasNextLine()) {
        String n = console.nextLine();
        Integer x = Integer.parseInt(n.substring(n.length()-1));
        //System.out.println(x);
        Integer y = Integer.parseInt(n.substring(0, 1));
        //System.out.println(y);
        String out;
        if (y % 2 == 0 && x % 2 == 0)
        {
            out = "$"+n.substring(1, n.length()-1)+"$";
        }
        else if (y % 2 > 0 && x % 2 > 0) {
            out = "X" +n.substring(1, n.length()-1) + "X";
        }
        else if (x == 0); 
        {
        out = n.substring(0, n.length()-1)+ "#";
        }
        System.out.println(out);
    }
}