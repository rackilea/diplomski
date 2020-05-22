for (int i = 0; i < up.length; i++) {
    int distance = up[i];   // Combined =0 with +=up[i]
    int days = 1;           // Combined =0 with ++
    for (;;) {
        if (Top[i] <= distance)
            break;
        distance -= down[i];   // else clause eliminated
        distance += up[i];
        days++;
    }
    System.out.println(days);
}