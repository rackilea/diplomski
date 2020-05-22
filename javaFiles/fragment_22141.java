ArrayList<Double> list = Arrays.asList(1.0, 2.0, 3.0);
ArrayList<Double> doubledList = applyFunctionToArrayList(list, 
  new Function<Double>{
    Double Func(Double x){
        return x * 2;
    }
});