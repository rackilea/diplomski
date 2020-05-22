abstract class Super {
}

class Child1 extends Super {
}

class Child2 extends Super {
}

private static List<? extends Super> myList;

public static void main(String[] args) {
    myList.add(new Child1());
    myList.add(new Child2());
}