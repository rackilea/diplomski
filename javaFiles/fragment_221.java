private static void quickSort(Integer[] ary, int lo, int hi) {
//pick num @ lo to be pivot
int pivot = lo;
int i = lo+1;
int j = hi;

if( lo==hi) {
    return;
}

//while(i <j) {
for(;;){//change from while to infinite for
    while(ary[i].compareTo(ary[pivot]) <=0 && i<hi ) {//changed from if to while with boundary conditions
        i++;

    }
    while(ary[j].compareTo(ary[pivot]) >0 && j>lo) { //change from if to while with boundary conditions and it is not >=0 only >
        j--;
    }
    if(i<j){ //changed from else to if
        int temp = ary[i];  
        ary[i] = ary[j];
        ary[j] = temp;

    }else{//added else block
      break;
   }
}
//you didn't handled i>j condition properly i.e when i>j you need to swap pivot and i-1
int temp1 = ary[pivot];
    ary[pivot] = ary[i-1];
    ary[i-1] = temp1;
    pivot = i-1;
//Not required
/*if(i == hi && j == hi) {
    if(ary[pivot].compareTo(hi) > 0) {
        int temp = ary[pivot];
        ary[pivot] = ary[hi];
        ary[hi] = temp;
        pivot = hi;

    }
    else {
        int temp1 = ary[pivot];
        ary[pivot] = ary[i-1];
        ary[i-1] = temp1;
        pivot = i-1;

    }

}*/

if(lo < pivot -1) {
    quickSort(ary, lo, pivot-1);
}

if(pivot +1 < hi) {
    quickSort(ary, pivot+1, hi);
 }
}