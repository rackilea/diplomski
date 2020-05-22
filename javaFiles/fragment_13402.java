PrintStream ps = new PrintStream("\file.txt");
PrintStream orig = System.out;
System.setOut(ps);
//TODO: stuff with System.out.println("some output");
System.setOut(orig);
ps.close();