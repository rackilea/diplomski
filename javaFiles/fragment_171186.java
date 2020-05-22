Observable.defer(
  () -> {
     if (!InputSystem.isInputOn())
       return Observable.empty();
     else 
       return yourInput
         .flatMap(Grid::handle)
         .flatMap(Grid::check)
         .delay(300, TimeUnit.MILLISECONDS)
         .flatMap(Grid::clean)
         .repeat();
    })
  .subscribe(...);