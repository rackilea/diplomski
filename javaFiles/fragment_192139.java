public static void count(char[] grade)  {
   int numofa = 0, numofb = 0, numofc = 0, numofd = 0, numoff = 0;

   for (int i = 0; i < grade.length; i++){
      if (grade[i] == 'A'){
         numofa++;
      }else if (grade[i] == 'B'){
      numofb++;
      }else if (grade[i] == 'C'){
         numofc++;
      }else if (grade[i] == 'D'){
         numofd++;
      }else if (grade[i] == 'F'){
         numoff++;
      }   
   }
}