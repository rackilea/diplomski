new Comparator<Customer>() {

public int compare(Customer o1, Customer o2) {
    if(o1.getName() == null){ return -1;}

    if(o2.getName() == null){ return 1;}
    return o1.getName().compareTo(o2.getName());
}
}