for (int i = 0; i < up.length; i++) {   // i++ moved here
    int distance = 0;   // Moved to top of loop and declared here
    int days = 0;       // Moved to top of loop and declared here
    for (;;) {
        distance += up[i];
        days++;
        if (Top[i] <= distance) {
            break;
        } else {
            distance -= down[i];
        }
    }
    System.out.println(days);
}