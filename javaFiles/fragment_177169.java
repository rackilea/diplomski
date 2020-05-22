public block getBlockUnderneath (int x, int y){
    for(final block b : blocks){
         if (b.x == x) {
             return b;
         }
    }
    throw new NoSuchElementException();
}