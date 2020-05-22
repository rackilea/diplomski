public class Symmetric{
    public static void main (String[] args) {
        int i =0;
        int j=args.length-1;

        boolean sym =true;
        while(i < j) {
            if (!args[i].equals(args[j])){
                System.out.println("Not symmetric at arg "+i+":"+args[i]+" and "+j+":"+args[j]);
                sym = false;
                break;
            }
            i++;
            j--;
        }
        if (sym) System.out.println ("All args symmetric");
    }
}