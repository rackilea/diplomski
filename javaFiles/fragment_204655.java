public int search(int[] items, int searchTerm, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex)/2 ;
        System.out.println("Midpoint: "+midIndex);
        if(searchTerm == items[midIndex]) {
            return midIndex;
        } else if(searchTerm > items[midIndex]) {
            return search(items, searchTerm, midIndex, endIndex);
        } else if(searchTerm < items[midIndex]) {
            return search(items, searchTerm, startIndex, midIndex);
        } else {
            return -1;
        }
        return -1;
    }