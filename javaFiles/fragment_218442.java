public class Sample {
    public static void main (String[] args) {
        Scanner newScan = new Scanner (System.in);

        System.out.println ("Enter a 3 digit number: ");
        String line = newScan.nextLine ();
        int digit;
        while (true) {
            if (line.length () == 3) {
                try {
                    digit = Integer.parseInt (line);
                    break;
                }
                catch (NumberFormatException e) {
                    // do nothing.
                }
            }

            System.out.println ("Error!(" + line + ") Please enter a 3 digit number: ");
            line = newScan.nextLine ();
        }

        System.out.println (digit);
    }
}