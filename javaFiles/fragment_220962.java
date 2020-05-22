SimpleStack<Integer> s1 = new SimpleStack<>();
s1.push(1);
s1.push(2);
s1.push(3);

System.out.println(s1.pop()); // print 3
System.out.println(s1.pop()); // print 2
System.out.println(s1.pop()); // print 1

StackWithComparator<Integer> s2 = new StackWithComparator<>(new Comparator<Integer>() {
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
    }
});
s2.push(1);
s2.push(2);
s2.push(3);
s2.push(0);
s2.push(4);

System.out.println(s2.min() + " " + s2.pop()); // print 0 4
System.out.println(s2.min() + " " + s2.pop()); // print 0 0
System.out.println(s2.min() + " " + s2.pop()); // print 1 3
System.out.println(s2.min() + " " + s2.pop()); // print 1 2
System.out.println(s2.min() + " " + s2.pop()); // print 1 1