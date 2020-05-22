public static void main(String args[]) {
   Console console = System.console();
   BufferedReader reader = new BufferedReader(console.reader());
   main2(reader, console.writer(), args);
}

static void main2(BufferedReader reader, Writer writer, String args[] {
   String str = reader.readline();
   System.out.println("halo"+str);
}