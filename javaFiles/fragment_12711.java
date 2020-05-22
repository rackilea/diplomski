public Student(String nm, int t1, int t2, int t3) {
    name = nm.replaceAll("\\|", "");
    test1 = t1;
    test2 = t2;
    test3 = t3;
}

public void setName(String nm) {
    name = nm.replaceAll("\\|", "");
}