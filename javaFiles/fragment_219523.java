FileOutputStream f = new FileOutputStream("test.txt");
PrintStream ps = new PrintStream(f);
ps.print("line1");
ps.println(); //this writes your new line
ps.print("line2");
ps.close();