RxView.clicks(this.btnNext)
  .map(none -> this.editTextKey.getText().toString())
  .filter(x -> !x.isEmpty())
  .flatMapSingle(key -> new Api(key).id().subscribeOn(Schedulers.io()))
  .observeOn(AndroidSchedulers.mainThread())
  .subscribe(this::showId, err -> {
    Log.e(this.getClass().getSimpleName(), "Login error", err);
  })