File score = new File("quiz.txt");
Scanner scn = new Scanner(new FileInputStream(score));
String buffer = "";
while (scn.hasNext()) {
      buffer += scn.nextLine() + "\n";
}
String[] content = buffer.trim().split(" ");
String name  = content[0] ;
Student student = new Student(name);
for (int a = 1 ; a < content.length; a++) {
    int scoreval = Integer.parseInt(content[a]);
    student.addQuiz(scoreval);
}