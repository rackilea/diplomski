private Observable<Stuff> stuff = retrofitApi.getStuff().share();

public Observable<Stuff> getStuff() {
    return stuff
        .someOperatorsHere();
}