List<Foo> originalList = Collections.synchronizedList(new ArrayList());

public void mainThread() {
    while(true)
        originalList.add(getSomething());
}

public void workerThread() {
    while(true) {
        List<Foo> copiedList;
        synchronized (originalList) {
             copiedList = originalList.add(something);
        }
        for (Foo f : copiedList) process(f);
    }
}