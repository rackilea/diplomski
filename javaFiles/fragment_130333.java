Map<String, Integer> map = new HashMap<String,Integer>();

//you have two lists with those strings, called list1 and list2.
// list1<String> and list2<String> have same size

String key = null;
for(int i=0;i<list1.size();i++){
    key = list1.get(i) + list2.get(i);
    if(map.containsKey(key))
        map.get(key)++;
    else
        map.put(key,1);
}

//now the map has been filled, you can go through the map, 
//and check the value, if value == 1, then the key is unique.
//for those value >1, you know, which string pair is not unique, 
// and how many times it shows.