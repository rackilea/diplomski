public void doSomething(List list) {
    if(list.size() > 0) {
        Object obj = list.get(0);
        if(obj instanceof Data) {
           doSomethingData((List<Data>)list);
        } else if (obj instanceof Double) {
           doSomethingDouble((List<Double>)list);
        }
    }
}