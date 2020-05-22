System.out.println("");
System.out.println("Please enter a student's name: ");
String studentName = userInput.next();

Student student = map.get(studentName);
if (student!=null){
      System.out.println(studentName + "'s quiz scores:");
      int[] quizArray = student.getQuizGrades();
      for (int counter1 = 0; counter1 < quizArray.length; counter1++) {
         System.out.println(quizArray[counter1]);
      }
 }