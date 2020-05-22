public static List<House[]> foo(House[] houses, List<House> buffer) {
    List<House[]> list = new ArrayList<House[]>();
    for (House house : houses) {
        if (house.getPosition() == buffer.size()) {
            buffer.add(house);
            if (house.getPosition() == 4) { // base case, no recursive call
                list.add(buffer.toArray(new House[buffer.size()]));
                buffer.remove(buffer.size() - 1);
            } else { // recursive case
                list.addAll(foo(houses, buffer));
            }
        }
    }
    if (buffer.size() > 0) {
        buffer.remove(buffer.size() - 1);
    }
    return list;
}