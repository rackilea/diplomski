public HashMap<Tuple<String, String>, Integer> countStuff (HashMap<Tuple<String, String>, Integer> stuffToBeCounted){

        HashMap<Tuple<String, String>, Integer> result = new HashMap<Tuple<String, String>, Integer>();
        HashMap<String, Integer> countedStuff = new HashMap<String, Integer>();

        for (Tuple<String, String> tuple : stuffToBeCounted.keySet()) {
           if(countedStuff.containsKey(tuple.v1())){
              Integer oldValue = countedStuff.get(tuple.v1());
              countedStuff.put(tuple.v1(), oldValue+1);
           }
           else{
              countedStuff.put(tuple.v1(), 1);
           }
        }

        for(Tuple<String, String> tuple : stuffToBeCounted.keySet()){
           result.put(tuple, countedStuff.get(tuple.v1()));
        }

        return result;
  }