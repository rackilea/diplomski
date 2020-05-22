Comparator<MyClass> myRules = new Comparator<MyClass>() {

    @Override
    public int compare(MyClass o1, MyClass o2) {
        int order = Integer.compare(getOrder(o1), getOrder(o2));
        return (order != 0 ? order : o1.aString.compareTo(o2.aString));
    }

    private int getOrder(MyClass m) {
        if (m.aString.equals("Hi")) {
            return 0;
        }
        else if (m.aString.startsWith(" ")) {
            return 1;
        }
        else {
            return 2;
        }
    }
};