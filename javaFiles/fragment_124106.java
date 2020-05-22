int min1 = Integer.MAX_INT;
int idx1 = -1;
int min2 = Integer.MAX_INT;
int idx2 = -1;

for(int i=0;i<array.length;i++) {
    // skip empty items
    if(array[i]==0)
         continue;

    if (array[i] < min1) {
         min2 = min1;
         idx2 = idx1;
         min1 = array[i];
         idx1 = i;
    }
    else if (array[i] < min2) {
         min2 = array[i];
         idx2 = i;
    }
}