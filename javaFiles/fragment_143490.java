private int size; //non static

private static <S extends Comparable<S>> MyList<S> leftHalf(MyList<S> list) {
    MyList<S> leftSide = new MyList<S>();
    int middle = list.size() /2;
    for (int countToMiddle = 0; countToMiddle < middle; countToMiddle++) {
        leftSide.addEnd(list.head());
    }

    return leftSide;
}