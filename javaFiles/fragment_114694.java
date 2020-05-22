public static List<House[]> foo(House[] houses, List<House> buffer) {
    List<House[]> list = new ArrayList<House[]>();
    for (House house : houses) {
        if (house.getPosition() == buffer.size()) {
            buffer.add(house);
            if (house.getPosition() == 4) { 
                list.add(buffer.toArray(new House[buffer.size()]));
                buffer.remove(buffer.size() - 1);
            } 
        }
    }
    return list;
}