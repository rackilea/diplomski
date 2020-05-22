// Approach 1
Observable.interval(1, TimeUnit.SECONDS).filter( i -> checkBox.isEnabled())

// Approach 2
Observable.interval(1, TimeUnit.SECONDS)
  .withLatestFrom(
    RxCompoundButton.checkedChanges(checkBox),
    (isChecked, intervalCounter) -> {
            if (!isChecked) {
                return Optional.empty();
            } else {
                return Optional.of(intervalCounter);
            }
     }).filter(Optional::isPresent).map(Optional::get)