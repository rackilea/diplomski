Set<String> keySet = map.keySet();
System.out.println("");
System.out.println("Please enter a student's name: ");
String studentName = userInput.next();
for (String currentKey : keySet) {

     Student student = map.get(currentKey);

     if(studentName == currentKey){

             System.out.println(currentKey + "'s quiz scores:");
             int [] quizArray = student.getQuizGrades();
              for(int counter1 = 0; counter1 < quizArray.length; counter1++ ){
                      System.out.println(quizArray[counter1]);
               }
      }

}