RxBottomNavigationView.itemSelections(sections)
.subscribeOn(AndroidSchedulers.mainThread())      // <------------------------
.map(menuItem -> menuItem.getTitle().toString())  // main thread
.observeOn(Schedulers.computation())              // <------------------------
.map(this::insertCategoryHeadersForSection)       // background
.observeOn(AndroidSchedulers.mainThread())        // <------------------------
.compose(bindToLifecycle())
.subscribe(itemInfos ->                           // main
    dishRecyclerAdapter.animateTo(itemInfos));