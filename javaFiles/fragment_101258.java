public static Node selectionSort_asc(Node head){ 
...
    if(curr.item><min.item) {
        prev = min;
        min = curr;
    }
...
}

public static Node selectionSort_desc(Node head){ 
...
    if(curr.item>max.item) {
        prev = max;
        max = curr;
    }
...
}