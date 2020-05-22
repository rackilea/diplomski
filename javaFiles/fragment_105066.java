LinkedListMultimap<String, LinkedListMultimap<String,Integer>>  map =  LinkedListMultimap.create();

LinkedListMultimap<String,Integer> m = LinkedListMultimap.create();

//put some values
m.put("value1", 1);
m.put("value2", 2);
m.put("value3", 3);

map.put("one", m);

for (Object value1 : map.values()) { 
    for (Object value2 : ((LinkedListMultimap<String,Integer>)value1).values()) { 
        System.out.println((Integer)value2);
    }
}