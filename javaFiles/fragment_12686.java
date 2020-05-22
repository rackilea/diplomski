int i = 0;
    for(MLDataPair pair: trainingSet ) {
    i++;
    final MLData output = network.compute(pair.getInput());
    if(i == trainingSet.size()-1){
         System.out.println("actual=" + output.getData(0));
       }
    }