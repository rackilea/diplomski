public boolean correctOrder(Node a, Node b) {
    if (a.count > b.count)
       return true;
    else if (a.count < b.count)
       return false;
    else
       return a.word.compareTo(b.word) <= 0;
}