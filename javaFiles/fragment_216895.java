PublishSubject<Token> publishToken = PublishSubject.create();

//notify others that you got a Token
publishToken.onNext(myToken);
..
..
//in other place (eg fragment)
getTokenEventBus().subscribe(token -> {
  //do your other call
 }, throwable ->{ 
  //handle error
 }, () -> {
  //event complete
});