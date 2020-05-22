mData.getItemsObservable() // Observable<List<Item>>
    .compose(...)
    .map(v -> Ix.from(v).filter(w -> w.someCondition()).toList())
    .subscribe(items -> {
        // ...
    }, error -> {
        // ...
    });