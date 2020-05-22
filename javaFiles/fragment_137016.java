private Completable validateLines(List<String> lines) {
            return Observable.fromIterable(lines)                
                          .subscribeOn(Schedulers.computation())
                          .map(lineParser::parse)
                          .map(lineValidator::validator)    //validation returns Optional<ValidationError>
                          .flatMapCompletable(optional -> optional.isPresent() ? Completable.error(new ValidationError()) : Completable.complete()); // Throw an error whenever a validation error is present , else continue
        }