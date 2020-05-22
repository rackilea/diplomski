eventBus.localConsumer(some_addres)
    .toObservable()
    .subscribe(message -> {
                 try {
                     ... <-- exception here
                     message.reply(...);
                 } catch (Exception e) {
                     ...handle exception...
                    message.error(...);
                 }
               })