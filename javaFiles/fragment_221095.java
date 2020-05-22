Scanner scan = new Scanner(System.in);
String s = scan.nextLine();
PrintWriter p = new PrintWriter("outputFile.txt");
p.println(s);
...
p.close();