PrintStream  ps4=System.out; // save
  FileOutputStream fout=new  FileOutputStream("aa.txt");
  PrintStream ps =new PrintStream(fout);
  System.setOut(ps);
  System.out.println("hello ");
  System.out.println("hay");
  System.setOut(ps4);  // restore
  System.out.println("hello world");