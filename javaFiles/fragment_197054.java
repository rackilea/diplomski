Map<String, List<Number>> map = new HashMap<String,List<Number>>();

List<Number> integers =new ArrayList<Number>();
integers.add(Integer.valueOf(1));
map.put("integers", integers);

List<Number> floats = new LinkedList<Number>(); 
floats.add(Float.valueOf(5.2f));
map.put("floats", floats);