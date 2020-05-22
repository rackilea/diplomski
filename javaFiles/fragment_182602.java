for(int x=0; x<=reps; x++){

   int currentMin = Integer.MAX_VALUE;  // Do this here.
   //int currentMinIndex = -1;  // This is never used??

   for (int i=0; i < ontarioBankInfoInt.size() - 1; i++) {
        int value = ontarioBankInfoInt.get(i);
        if (value < currentMin && value > pastMin) {
            currentMin = value;
            //currentMinIndex = i;     
        }
   }

   pastMin = currentMin; // I also think you want this here.
   yearArray.add(currentMin);
}