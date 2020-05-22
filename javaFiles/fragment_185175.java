class C1<T extends Comparable<T>> {  // first case
}

class C2<T extends Comparable> {  // second case
}

class A {  // some super class
}

class B extends A implements Comparable<A> {  // comparable to super class
    @Override
    public int compareTo(A o) {
        return 0;
    }
}