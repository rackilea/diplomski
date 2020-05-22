parallel_quicksort(level, interval) {
    // compute subintervals interval1, interval2
    if(level < cutoff) { 
        spawn1: parallel_quicksort(level + 1, interval1);
        spawn2: parallel_quicksort(level + 1, interval2);

        join1();     
        join2();
    } else {
        quicksort(interval1);
        quicksort(interval2);
    }
}