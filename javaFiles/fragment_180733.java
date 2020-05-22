public void mergeSort(ArrayList<Comparable> a, int first, int last) {
    int mid = (first + last)/2;
    if(first == last){
    }else if(last - first == 1){
        // you only merge if last - first == 1...
        merge(a,first, mid ,last);              
    }else{
        last = mid;
    }
}