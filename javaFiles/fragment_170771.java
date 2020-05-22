Particle[] arr;
int targetD = 300; // Target (maximum) number of active particles
int x = 0;
int y;
int d = 0; // Number of active particles, d stands for distance between x and y
while (true) {
    y = x + d;
    for (int i = x; i < y; i++) {
        int index = i % arr.length;
        // Update particles using arr[index]
    }
    if (d < targetD) {
        d++;
    } else {
        x = (x + 1) % arr.length;
    }
}