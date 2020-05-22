public static int intersectionSizeMergeAndSort(studentList L1, studentList L2) {
   /* Write your code for question 4 here */
   int intersectionSize = 0;
   int[] C = new int[L1.studentID.length + L2.studentID.length];
   for (int i = 0; i < L1.studentID.length; i++) {
      C[i] = L1.studentID[i];
   }
   for (int i = 0; i < L2.studentID.length; i++) {
      C[i + L1.studentID.length] = L2.studentID[i];
   }
   Arrays.sort(C);
   int pointer = 0;
   while (pointer < (C.length - 1)) {
       if (C[pointer] == C[pointer + 1]) {
          intersectionSize = intersectionSize + 1;
          pointer = pointer + 2;
       } else {
          pointer = pointer + 1;
       }
    }
    return intersectionSize;
}