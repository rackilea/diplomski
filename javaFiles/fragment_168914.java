Observable.combineLatest(
        RxView.touches(vSecretLeft)
                .map(motionEvent -> motionEvent.getAction())
                .filter(action -> action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL)
                .startWith(MotionEvent.ACTION_UP),
        RxView.touches(vSecretRight)
                .map(motionEvent -> motionEvent.getAction())
                .filter(action -> action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL)
                .startWith(MotionEvent.ACTION_UP),
        RxTextView.textChanges(etxtSearchFilter)
                .debounce(1, TimeUnit.SECONDS)
                .map(c -> c.toString().trim())
                .filter(s -> !s.isEmpty()),
        (leftAction, rightAction, entered) -> {
            boolean overrideFilter = leftAction == MotionEvent.ACTION_DOWN && rightAction == MotionEvent.ACTION_DOWN;
            return overrideFilter || !isInappropriate(entered) ? entered : "BLOCKED";
        })
        .subscribe(s -> Log.i("ObservableCombineLatest", "s: " + s));