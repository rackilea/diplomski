for (int i = 0; i < up.length;) {
    for (;;) {   // Forever-loop
        distance += up[i];
        days++;
        if (Top[i] <= distance) {
            System.out.println(days);
            i++;
            days = 0;
            distance = 0;
            break;   // Break out, since we changed i
        } else {
            distance -= down[i];
        }
    }
}