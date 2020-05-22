Collections.sort(shapeList, new Comparator<MyClass>() {
    @Override
    public int compare(MyClass c1, MyClass c2) {
        return (new Double(c1.getRatio())).compareTo(c2.getRatio());
    }
});