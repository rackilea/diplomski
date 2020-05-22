while (move.next != null) {
    if (move.next.data % 2 == 0) {
        move.next = move.next.next;
        con = true;
    } else {
        move = move.next;
    }
}