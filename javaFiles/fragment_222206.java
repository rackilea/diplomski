@RequestMapping(value = "/", method = RequestMethod.POST)
public ResponseEntity subscribe(@RequestBody SomePayload payload) {
    Completable.fromAction(() -> someService.longRunningVoidMethod(payload))
           .subscribeOn(Schedulers.io())
           .subscribe();
    return new ResponseEntity(HttpStatus.OK);
}