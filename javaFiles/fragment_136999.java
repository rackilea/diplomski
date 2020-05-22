for (int i = 0; i < up.length;) {
    distance += up[i];
    days++;   // Statement moved outside
    if (Top[i] <= distance) {
        System.out.println(days);
        i++;
        days = 0;
        distance = 0;
    } else {
        distance -= down[i];
    }
}