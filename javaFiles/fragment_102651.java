//Contain the Fibonacci number divisible by 2.

 List<Long> divSeries = new ArrayList<>();

 for(int i=2; i < limit; i++){
      series[i] = series[i-1] + series[i-2];
      if ((series[i] % 2) == 0){ 
              divSeries.add(series[i]);
        }   
   }   

  //To print the result
  for(long i : divSeries)
        System.out.print(i + " ");