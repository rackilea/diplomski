List<Foo> originalList = Collections.synchronizedList(new ArrayList());

public void mainThread() {
    while(true)
        originalList.add(getSomething());
}

public void workerThread() {
    while(true) {
        for (Foo f : originalList.toArray(new Foo[0])) 
            process(f);
    }
}