if(obj1.getIntOne()==null && obj2.getIntOne()==null) {
    return obj1.getIntTwo().compareTo(obj2.getIntTwo());
} else if(obj1.getIntOne()==null && obj2.getIntOne()!=null) {
    // Null is greater than any non-null number
    return 1;
} else if(obj1.getIntOne()!=null && obj2.getIntOne()==null) {
    // Non-null is smaller than null
    return -1;
} else {
    return obj1.getIntOne().compareTo(obj2.getIntOne());
}