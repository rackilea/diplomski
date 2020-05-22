getTextChangedObservable(searchView)
    .debounce(750, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
    .distinctUntilChanged()
    .subscribe(query -> {
        Log.d("Search", "Query " + query);
    });