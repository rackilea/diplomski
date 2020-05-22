@Override
public int compare(classA c1, classA c2) {
    long value1 = c1.getDate().getTime();
    long value2 = c2.getDate().getTime();
    if (value2 > value1) {
        return 1;
    } else if (value1 > value2) {
        return -1;
    } else {
        return 0;
    }
}

public static void main(String[] args) {
    classA o1 = new classA();
    o1.setDate(new Date());

    classA o2 = new classA();
    o2.setDate(new Date());
    CompareObjects compare = new CompareObjects();
    int i = compare.compare(o1, o2);
    System.out.println(" Result : " + i);

}