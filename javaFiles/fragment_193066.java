Observable.zip(retrofitApi.getUser("ALEX"), retrofitApi.getUser("ELISA"), retrofitApi.getUser("JOE"), (u1, u2, u3) -> {
  // prepare your returned users in a way suitable for further consumption
  // in this case I put them in a list
  return Arrays.asList(u1, u2, u3);
})
.subscribeOn(Schedulers.io())
.observeOn(AndroidSchedulers.mainThread())
.subscribe( listOfUsers -> // TODO: do something with your users)