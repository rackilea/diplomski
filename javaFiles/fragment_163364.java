boolean exists = false;
for (int[] move : moves) {
    if (move[0] == i && move[1] == j) {
        exists = true;
        break;
    }
}