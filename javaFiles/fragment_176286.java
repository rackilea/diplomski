public List<IndexClass> sort(Map<Integer,List<Double>> dist) {
      //Use TreeMap because it will auto sort keys
      TreeMap<Double,List<IndexClass>> treeMap = new TreeMap<Double,List<IndexClass>>();
      for (Map.Entry<Integer, List<Double>> entry : dist.entrySet()) {
           List<Double> distValues = entry.getValue();
           for (int i = 0; i < distValues.size(); i++) {
                Double value = distValues.get(i);
                IndexClass index = new IndexClass();
                index.row = entry.getKey();
                index.column = i;
                //There is a duplicate value, simple add the index into the list
                if (treeMap.contains(value) {
                     treeMap.get(value).add(index);
                //It is a new value, so create a list instead
                } else {
                     List<IndexClass> indexList = new ArrayList<IndexClass>();
                     indexList.add(index);
                     treeMap.put(value, indexList.add);
                }
           }
      }
      List<IndexClass> finalList = new ArrayList<IndexClass>();
      //Add all list items together
      for (Map.Entry<Double,List<IndexClass>> entry : treeMap.entrySet()) {
           finalList.addAll(entry.getValue());
      }     
      return finalList;
 }