Observable<Optional<Integer>> o1 = Observable.combineLatest(
        RxCompoundButton.checkedChanges(checkBox)
        , Observable.interval(1, TimeUnit.SECONDS)
        , (isChecked, intervalCounter) -> {
            if (!isChecked) {
                return Optional.empty();
            } else {
                return Optional.of(intervalCounter);
            }
        }
)

Observable<Integer> o2 = o1.filter(Optional::isPresent).map(Optional::get)