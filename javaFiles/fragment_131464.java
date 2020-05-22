public <T extends Comparable<? super T>> void doSomethingTheOPWants() {
    ...
    T m1 = column.getMember(o1);
    T m2 = column.getMember(o2);
    int compareTo = m1.compareTo(m2);
}