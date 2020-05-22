requestLogin()
   .andThen(
         hasProjects()
            .filter(value -> !value)
            .flatMapCompletable(value -> createDefaultProject()))
   .subscribe(() ->{}, throwable -> {
         // All errors will end up here
     });