public boolean remove(int position) {
    if(isEmpty() && position>count && position > MAX_ITEMS){
        return false
    }
        for (int i = 0; i < count; i++) {
            if (items[i] == position) {
                --count;
                for (; i < count; ++i) {
                    items[i].data = items[i + 1].data;
                }
                return true;
            }
        }
    return false;        
}