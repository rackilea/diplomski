public static int[] count(char[] grade)  {
   int[] numOfEach = new int[5];  //5: a, b, c, d, f
   int idxA = 0;
   int idxB = 1;
   int idxC = 2;
   int idxD = 3;
   int idxF = 4;

   for (int i = 0; i < grade.length; i++){
      if (grade[i] == 'A'){
         numOfEach[idxA]++;
      }else if (grade[i] == 'B'){
         numOfEach[idxB]++;
      }else if (grade[i] == 'C'){
         numOfEach[idxC]++;
      }else if (grade[i] == 'D'){
         numOfEach[idxD]++;
      }else if (grade[i] == 'F'){
         numOfEach[idxF]++;
      }   
   }
   return  numOfEach;
}