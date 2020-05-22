final int MAX_TABLES = 4;
final int OPENING= 9;
final int CLOSING= 21;
final int SLOTS= 4;
int[] booking = new int[(CLOSING - OPENING) * SLOTS];

public void main() {
    // no tables booked
    Arrays.fill(booking,0);

    doBooking(3, 0, 8);
    doBooking(1, 4, 8);
    doBooking(1, 4, 12);
}

public void doBooking(int tables, int startSlot, int endSlot) {
    for (int slot= startSlot, slot < endSlot, slot++) {
        if (booking[slot] + tables > MAX_TABLES) {
            throw new Exception("no free table at slot "+slot);
        }
    }
    for (int slot= startSlot, slot < endSlot, slot++) {
        booking[slot] += tables;
    }
}