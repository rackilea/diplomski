int minIndex = 0;
int min = Integer.MAX_VALUE;
for (int i=0; i<list.size(); i++) {
    int max = Integer.MIN_VALUE;
    for (int j=0; j<list.get(i).length; j++) { // find max element of current array
        if (list.get(i)[j] > max) {
            max = list.get(i)[j]; 
            if (max > min) {
                break; // we already know the max of this array is not the smallest max
            }
        }
    }
    if (max < min) { // check if the max of the current array is the smallest max so far
        min = max;
        minIndex = i; //index of the array in arraylist
    }
}