HashSet<Your_Class> set = ...//HashSet that contains data
 int index = 0;
 HashMap<Your_Class,Integer> map = new HashMap<>();
 for(Your_Class item : set){
     map.put(item, index++);
 }
 //Generate all the set with those indexes, and replace them with map.get(index)