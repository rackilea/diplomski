public Iterator() {
            // init first position - assuming first element is always available somewhere in the array.
            for (int i = 0;i<items.length;i++) {
                if (items[i] == first) {
                    currentIndex = i;
                    break;
                }
            }
        }
    @Override
    public boolean hasNext() {
        if (currentIndex >= size()) {
            currentIndex = 0;
        }
        return  items[currentIndex] != null;
    }