double grades = 0;
int entries = 0;
while(true){
      String inputString = //Get user input here       

      if(inputString.equals("Your Termination Text"))
           break;
      else{
        grades += Double.parseDouble(inputString);
        entries++;
      }
 }
 double averageGrade = grades / entries;