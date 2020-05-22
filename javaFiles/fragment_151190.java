double abc = 0.0;
for (int k = 0; k < formelHolder.length - 1; k++){

   if (formelHolder[k].matches("\\d+(\\.\\d+)?")){
      double f = Double.parseDouble(formelHolder[k]);
      abc += massHolder[k-1]*(f-1);
   } else {
      abc += massHolder[k];
   }
}