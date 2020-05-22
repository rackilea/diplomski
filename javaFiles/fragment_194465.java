double average = LongStream
   .of(-4480186093928204294L, -1340542863544260591L, -6004296286240039273L)
   .mapToDouble(x -> x)
   .average()
   .getAsDouble();

-3.9416750812375014E18