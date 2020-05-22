Double sumOfSameIndex =0.0;    

Map<Key1, Map<Key2, List<Double>>> map = new LinkedHashMap<Key1, Map<Key2, List<Double>>>();
Iterator<Map.Entry<Key1, Map<Key2, List<Double>>>> outerIterator = map.entrySet().iterator();


        while(outerIterator.hasNext()){

        Map.Entry<Key1, Map<Key2, List<Double>>> entryForOuterMap= outerIterator.next();
        Iterator<Map.Entry<Key2, List<Double>>> innerIterator = entryForOuterMap.getValue().entrySet().iterator();

           while(innerIterator.hasNext()){

                Map.Entry<Key2, List<Double>> entryForInnerMap = innerIterator.next();

           // entryForInnerMap.getValue() returns List<Double> 
           List<Double> getList= entryForInnerMap.getValue(); 

                // REPLACE THIS x WITH the INDEX OF ARRAY YOU WANT TO SUM 
              sumOfSameIndex = sumOfSameIndex + getList.get ( x );  

          }
     }