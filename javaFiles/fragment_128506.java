public int rank (Key key) {
    int count = 0;
    for(Node x = first; x != null; x = x.next){
        if (x.next < key){
            count++;
        }
        return count;  // <-- Note!
    }
}