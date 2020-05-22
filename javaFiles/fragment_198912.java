public static void main(String[] args) {   
    Room room1 = new Room(10,12,2,0);
    Room room2 = new Room(4,8,2,0);
    Room room3 = new Room(7,5,2,0);
    Room room4 = new Room(10,2,2,0);

    double result = similarity(room1, room2, room3, room4);
}

public static double similarity(Room ... r) {
    double sum = 0;
    for (int i=0; i<r.length-1; i++) {
        double a = Math.pow(r[i].getX() - r[i+1].getX(), 2);
        double b = Math.pow(r[i].getY() - r[i+1].getY(), 2);
        sum += a + b;
    }
    return Math.sqrt(sum);
}