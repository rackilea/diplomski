try (BufferedReader br = new BufferedReader(new FileReader("foo.txt"))) {
   String line;
   while ((line = br.readLine()) != null) {
       System.out.println(line);
   }
}