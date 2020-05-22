String[] questions = {"adorable", "able", "adventurous"};
String u = "able adorable asd";
String[] t = u.split(" ");
for (int y = 0; y < questions.length; y++) {
   for (int w = 0; w < t.length; w++) {
       if (t[w].equals(questions[y])) {
           System.out.print(t[w] + " ");
           break;
       }
    }
}