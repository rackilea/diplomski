public GradeBook(int[] grades)
 {
      //instantiate array with same length as parameter
      gradeBook = new int[grades.length];

      for ( int i = 0; i <= gradeBook.length-1; i++ )
      {
         gradeBook[i] = grades[i];
      }
   }