PublishSubject<Integer> subject = PublishSubject.create();

subject
  .debounce(1, TimeUnit.SECONDS)
  .subscribe(new Action1<Integer>() {
    public void call(Integer number) {
      doSomething(number);
    }
  });

public void called(int number){
  subject.onNext(number);   
}