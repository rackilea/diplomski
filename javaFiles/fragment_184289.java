//Take a Map with Integer as value and String as key.
    Map<String,Integer> result = new HashMap<String,Integer> ();
    //Iterate your List
    for(String s : dupeWordList)
     {
          if(map.containskey(s))
           { 
                  map.put(s,map.get(s)+1);
                  // Please consider casting here.
           }else
           {
                  map.put(s,1);
           }


       }