eventBus.localConsumer(some_addres)
    .toObservable()
    .subscribe(message -> {
                 ... <-- exception here
                 message.reply(...);
               })