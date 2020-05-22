ArrayList<ArrayList<Object>> root = new ArrayList<ArrayList<Object>>();

root.add(new ArrayList<Object>());
root.add(new ArrayList<Object>());
root.add(new ArrayList<Object>());
root.add(new ArrayList<Object>());

root.get(1).set(1, Object); //puts new object at position 1,1

Object o = root.get(1).get(1); //gets object from position 1,1