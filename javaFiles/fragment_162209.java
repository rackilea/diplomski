HashMap map = new HashMap<Integer, String>();
    map.put(1, new String[]{"1", "2"});
    System.out.println(map.get(1));
    System.out.println("got here");
    HashMap<Integer, String> otherRef = (HashMap<Integer, String>) map;
    System.out.println(otherRef.get(1)); //<-ClassCastException exception here