static int binarySearch(int[] arr, int key) { //Changed name to match with calling function name
int lo = 0;
int hi = arr.length - 1; //not array.length
while (lo <= hi) {

    int mid = lo + (hi - lo) / 2;
    if (key < arr[mid]) { 
       hi = mid - 1;
    } else if (key > arr[mid]) 
       lo = mid + 1;
    // you had one } here
    else return mid;
 }
 return -1;
}