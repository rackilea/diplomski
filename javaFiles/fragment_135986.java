private static double[][] personArrCreator(double[][] pArr, int num) {
   pArr[num] = new double[num + 1];
   if (num == 4) {
      return pArr;
   }
   return personArrCreator(pArr, num + 1);
}