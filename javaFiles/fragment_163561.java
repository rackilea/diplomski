String a[] = new String[]{"Hello.jpg","Goodbye.mp4","Free.xlsx","GettingStarted","File.81723.domain.8080.pdf"};
for (String s : a) {
if (s.matches(".*\\.[^.]+"))
    System.out.println(s + ": true");
else
    System.out.println(s + ": false");
}