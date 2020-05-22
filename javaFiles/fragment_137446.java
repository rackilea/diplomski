public int getLength(){
    MyObject cursor = this;
    int length = 0;
    while (cursor != null) {
       length += 1;
       cursor = this.next;
    }
}