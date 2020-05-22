class ClassNameComparator implements Comparator<YourClass> {

ClassNameComparator() {
}

@Override
public int compare(YourClass first, YourClass second) {
    if (first > second){
        return 1;
    } else if (first == second){
        return 0;
    } else return -1;
}
}