public void countAlphabets(String s){


      Map<Character,Integer> map= new HashMap<Character,Integer>();

      for(int i=0;i<s.length();i++){

          char c= s.charAt(i);
// Counting occurrence of alphabets
        if(map.containsKey(c)){
            map.put(c, map.get(c)+1);
        }
        else{
            map.put(c, 1);
        }
      }

     //Sorting Hashmap by values
  Set<Entry<String, Integer>> set = map.entrySet();
  List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
  Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
  {
      public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
      {
          return (o2.getValue()).compareTo( o1.getValue() );
      }
  } );
  for(Map.Entry<String, Integer> entry:list){
      System.out.println(entry.getKey()+" ==== "+entry.getValue());
  }
  }