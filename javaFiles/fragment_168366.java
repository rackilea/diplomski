Map<String, Integer> sum = new HashMap<String, Integer>();

for(int i=0; i<arraylist1.size(); i++){
    if(!sum.containsKey(arraylist1.get(i))) {
      sum.put(arraylist1.get(i), arraylist2.get(i));
    }else{
      sum.put(arraylist1.get(i), arraylist2.get(i) + sum.get(arraylist1.get(i)));
    }
}
System.out.println(sum);