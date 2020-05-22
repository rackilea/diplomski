Scanner sc = new Scanner(new File("file.txt"));
while (sc.hasNext()) {
     String token = sc.next(); 
         if (Pattern.matches("<=", token)) {
             System.out.println(token);
         }
}
sc.close();