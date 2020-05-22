public int getInputInt(Scanner in, int range) {
    while (in.hasNext()) {
        if (in.hasNextInt()) {
            int val = in.nextInt();
            if (val >= 0 && val < range) { // <-- from "0" to "range".
                return val;
            }
        } else {
            in.next();
        }
    }
    return -1;
}