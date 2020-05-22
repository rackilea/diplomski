int pivotIndex = random.nextInt(last-first) + first;
int pivotValue = getValueAt(pivotIndex);

while (up < down ) {

    while (getValueAt(up) < pivotValue) {
        up++;
    }
    while (getValueAt(down) > pivotValue) {
        down--;
    }
    if (up <= down) {
        swap(up,down);
        up++;
        down--;
    }