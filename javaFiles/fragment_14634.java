int row = 0;
int last = -1;
int matches = 1;
for (Integer mark : marks) {
    if (mark != last) {
        row += matches;
        matches = 1;
    } else {
        matches++;
    }
    System.out.println(row + ": " + mark);
    last = mark;
}