private Observable<Integer> getNFromCache(){
    return Observable.empty;
}


public Observable<Integer> getNumber(){
      return getNFromCache(scope)
              .switchIfEmpty(this::doHttpRequest);
}


private Observable<Integer> doHttpRequest(){
    return Observable.of(1)
                     .doOnSubscribe(() -> System.out.pritnln("START !"))
}

public static void main(String...args) {
   getNumber(); // display nothing => values are not emitted !
   getNumber().subscribe(); // display "START !"
}