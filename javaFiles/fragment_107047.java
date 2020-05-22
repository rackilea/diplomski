int p, q;
System.out.println("P\tQ\tAND\tOR\tXOR\tNOT");
p = 1; q = 1;
System.out.print(p + "\t" + q + "\t");
System.out.print((p&q) + "\t" + (p|q) + "\t");
System.out.println((p^q) + "\t" + (1-p)); // EDIT: was !p