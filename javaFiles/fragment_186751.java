// change method signature
private static void bubbleSort(int[] gradeArray, String[] nameArray){

  int n = gradeArray.length;
  int temp = 0;
  String temp2;

  for(int i=0; i<n; i++){
    for(int j=1; j<(n-i);j++){

      if(gradeArray[j-1]<gradeArray[j]){
        //swap
        temp=gradeArray[j-1];
        gradeArray[j-1]=gradeArray[j];
        gradeArray[j]=temp;

        // New code begin
        temp2=nameArray[j-1];
        nameArray[j-1]=nameArray[j];
        nameArray[j]=temp2;
        // New code end
      }
    }
  }
}