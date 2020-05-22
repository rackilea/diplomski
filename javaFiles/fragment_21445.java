class PriorityValueComparator implements Comparator<Human>{
    public int compare(Human x, Human y){
        if (y._priority != x._priority) return y._priority - x._priority;
        else return y._insertion_time - x._insertion_time;
    }
}