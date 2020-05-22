public Map<String,Integer> getCounts(ArrayList<Tester> list){

  Map<String,Integer> counter=new HashMap<String,Integer>();

  for(Tester s : list){

    if(counter.containsKey(s.getKey())){
      counter.put(s,counter.get(s.getKey())+1);
    }else{
      counter.put(s.getKey(),1);
    }

   }

   return counter;

}