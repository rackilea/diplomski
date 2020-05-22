for (MyObject o : list){
    for (MyObject o2 : list){
        if (o != o2 && o.equals(o2))
            doSomething();
    }
}