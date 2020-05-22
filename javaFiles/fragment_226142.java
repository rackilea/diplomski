public Optional<Integer> mo(Ws wsObject) {
    return wsObject.getFoo()
        .flatMap(f -> f.getBar())
        .flatMap(b -> b.getBaz())
        .flatMap(b -> b.getInt());        
}