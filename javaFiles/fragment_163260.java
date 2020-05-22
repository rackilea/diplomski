public static <T extends Comparable<T>> int binarySearch(T[] items, T target, int first, int last){

    if(first > last)
        return -1; // Base case for unsuccessful search
    else{
        int middle = (first + last) / 2; // Next probe index.
        int compResult = target.compareTo(items[middle]);
        if(compResult == 0)
            return middle; // Base case for unsuccessful search.
        else if (compResult <0)
            return binarySearch(items, target, first, middle -1);
        else
            return binarySearch(items, target, middle + 1, last);
    }
}

public static <T extends Comparable<T>> int binarySearch(T[] items, T target){
    return binarySearch(items, target, 0, items.length -1);
}

public static void main(String[] args) {
    String[] names = {"Caryn", "Debbie", "Dustin", "Elliot", "Jacquie", "Jonathan", "Rich"};

    int myName = binarySearch(names, "Dustin");
    System.out.println(myName);
}