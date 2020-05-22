private static boolean BinarySearch(Comparable[] ToSearch, Comparable ToFind, int first, int last){
    boolean found = false;
    int newComparisons = 0;
    int mid = first + (last - first) / 2;
    if(first > last){
        found = false;
        newComparisons = 1;
    }
    else if(ToFind.compareTo(ToSearch[mid]) == 0){
        found = true;
        newComparisons = 2;
    }
    else if(ToFind.compareTo(ToSearch[mid]) < 0) {
        found = BinarySearch(ToSearch, ToFind, first, mid - 1);
        newComparisons = 3;
    }
    else{
        found = BinarySearch(ToSearch, ToFind,mid + 1, last);
        newComparisons = 3;
    }
    comparisons += newComparisons;
    return found;
}