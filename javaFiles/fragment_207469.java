for (X x : xList) {
    List<Y> smallList = yBucket.get(x.someAttr());
    if (smallList != null) {
        for (Y y : smallList) {
            if (x.someAttr() == y.someAttr()) doSomething(x, y);
        }
    }
}