private void changeRange(int min, int max) {
    boolean found = false;
    int position=0;
    while(position<minArray.length && !found) {
        if(min>minArray[position] && min<maxArray[position]) {
            found = true;
            if(max>maxArray[position]) {
                maxArray[position] = max;
            }
        } else if(max>minArray[position] && max<maxArray[position]) {
            found = true;
            if(min<minArray[position]) {
                minArray[position] = min;
            }
        } else {
            position++;
        }
    }
}