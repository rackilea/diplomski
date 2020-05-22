Particle[] arr;
int x;
int y;
while (true) {
    // case x <= y: distance between x and y is y - x
    // case x > y: distance between x and y is y + arr.length - x
    for (int i = x > y ? x : x + arr.length; i < y + arr.length; i++) {
        int index = i % arr.length;
        // Update particles
    }
    x = (x + 1) % arr.length;
    y = (y + 1) % arr.length;
}