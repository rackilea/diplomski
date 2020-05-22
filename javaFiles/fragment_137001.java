int distance = 0;
int days = 0;
for (int i = 0; i < up.length;) {
    for (;;) {
        distance += up[i];
        days++;
        if (Top[i] <= distance) {
            break;
        } else {
            distance -= down[i];
        }
    }
    System.out.println(days);   // Moved outside forever-loop
    i++;                        // Moved outside forever-loop
    days = 0;                   // Moved outside forever-loop
    distance = 0;               // Moved outside forever-loop
}