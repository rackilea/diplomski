int[] ranges = new int { 50, 500, 5000, 50000 };

for (int n = 0; n < ranges.length && value > ranges[n]; n++) {
}

int range = n;
int newy = yaxis - range * 32;