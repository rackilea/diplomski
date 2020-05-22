List<Float> floats = ...;
 List<Integer> integers = new ArrayList<Integer>();
 for (Float item : floats) {
    integers.add(item.intValue());
 } 
 return integers;