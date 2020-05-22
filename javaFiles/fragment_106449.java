private static void finalFillerTotalSuperSpecial(List<String[]> initialList, HashMap<String,Object> mapa){

     String[] currentElement = null;
     String currentKey = null;

     String[] nextElement = null;
     String nextKey = null;
     int i=0,start,end;

     while (i < initialList.size()) {
     start = i;

     currentElement = initialList.get( i++ );
     currentKey = currentElement[0];

     if (i<initialList.size()){
         nextElement = initialList.get( i );
         nextKey = nextElement[0];
     }

     HashMap<String,Object> insideMap = new HashMap<String,Object>(); 
     mapa.put(currentKey, insideMap);

     while (currentKey.equals(nextKey) && i < initialList.size()) {
         currentElement = initialList.get( i++ );
         currentKey = currentElement[0];

         if (i<initialList.size()){
         nextElement = initialList.get( i );
         nextKey = nextElement[0];
         }

     }
     end = i;

     List<String[]> listOfCurrentElements = new ArrayList<String[]>();
     for (int j=start;j<end;j++)
         listOfCurrentElements.add( getNextArray(initialList.get(j)) );

     if ( listOfCurrentElements.get(0).length>1 )
         finalFillerTotalSuperSpecial(listOfCurrentElements,insideMap);
     else
         insideMap.put(listOfCurrentElements.get(0)[0], null);
     }



 }