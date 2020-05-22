public static char[] count(char[] grade)  {
   char[] numOfEachAsChars = new char[5];  //5: a, b, c, d, f
   int idxA = 0;
   int idxB = 1;
   int idxC = 2;
   int idxD = 3;
   int idxF = 4;

   for (int i = 0; i < grade.length; i++){
      if (grade[i] == 'A'){
         numOfEachAsChars[idxA]++;
      }else if (grade[i] == 'B'){
         numOfEachAsChars[idxB]++;
      }else if (grade[i] == 'C'){
         numOfEachAsChars[idxC]++;
      }else if (grade[i] == 'D'){
         numOfEachAsChars[idxD]++;
      }else if (grade[i] == 'F'){
         numOfEachAsChars[idxF]++;
      }   
   }
   return  numOfEachAsChars;
}