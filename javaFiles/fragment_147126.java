class A {

    public String getSomething() {
        return "A";
    }
}

class B {

    public String getSomethingElse() {
        return "B";
    }
}

class C implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        // Which is of what type?
        A a1 = o1 instanceof A ? (A) o1: null;
        A a2 = o2 instanceof A ? (A) o2: null;
        B b1 = o1 instanceof B ? (B) o1: null;
        B b2 = o2 instanceof B ? (B) o2: null;
        // Pull out their values.
        String s1 = a1 != null ? a1.getSomething(): b1 != null ? b1.getSomethingElse(): null;
        String s2 = a2 != null ? a2.getSomething(): b2 != null ? b2.getSomethingElse(): null;
        // Compare them.
        return s1 != null ? s1.compareTo(s2): 0;
    }

}