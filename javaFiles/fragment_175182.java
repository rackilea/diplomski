Map<String, ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
ArrayList<Integer> s1sValues = new ArrayList<Integer>();
s1s.add(1);
s1s.add(2);
map.put("s1", s1sValues);
//To add to existing
map.get("s1").add(3);//If you don't already have a reference
s1sValues.add(4);//If you do have the reference.