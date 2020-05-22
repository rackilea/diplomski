public static void main(String[] args) {
    boolean p, q;
    System.out.println("P\tQ\tAND\tOR\tXOR\tNOTp");

    p = true; q = true;
    System.out.print(print(p) + "\t" + print(q) +"\t");
    System.out.print(print(p&q) + "\t" + print(p|q) + "\t");
    System.out.println(print(p^q) + "\t" + print(!p));
    p = true; q = false;
    System.out.print(print(p) + "\t" + print(q) +"\t");
    System.out.print(print(p&q) + "\t" + print(p|q) + "\t");
    System.out.println(print(p^q) + "\t" + print(!p));
    p = false; q = true;
    System.out.print(print(p) + "\t" + print(q) +"\t");
    System.out.print(print(p&q) + "\t" + print(p|q) + "\t");
    System.out.println(print(p^q) + "\t" + print(!p));
    p = false; q = false;
    System.out.print(print(p) + "\t" + print(q) +"\t");
    System.out.print(print(p&q) + "\t" + print(p|q) + "\t");
    System.out.println(print(p^q) + "\t" + print(!p));
}

public static String print(boolean stat) {
    if(stat) return "1";        // if stat is true
    return "0";                 // else false
}