for (int i = 0; i < up.length; i++) {
    int distance = 0;
    int days = 0;
    distance += up[i];   // Moved here
    days++;              // Moved here
    for (;;) {
        if (Top[i] <= distance) {
            break;
        } else {
            distance -= down[i];
        }
        distance += up[i];   // Also moved here
        days++;              // Also moved here
    }
    System.out.println(days);
}