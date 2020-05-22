private TreeSet<Integer> up = new TreeSet<>(); // floors above currentFloor
private TreeSet<Integer> down = new TreeSet<>(); // floors below currentFloor
private int currentFloor = 0;
private Enum direction = direction.UP;

public void addFloor(int f) {
    if(f < currentFloor) {
        down.add(f);
    } else if(f > currentFloor) {
        up.add(f);
    }
    // else f == currentFloor, so don't add the floor to either queue
}

public int nextFloor() {
    if(direction == direction.DOWN) {
        return down.pollLast(); // highest floor in down, or null if empty
    } else {
        return up.pollFirst(); // lowest floor in up, or null if empty
    }
}