Observable.combineLatest(
        RxView.touches(vSecretLeft)
                .filter(motionEvent -> motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL),
        RxView.touches(vSecretRight)
                .filter(motionEvent -> motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL),
        RxTextView.textChanges(etxtSearchFilter)
                .debounce(1, TimeUnit.SECONDS)
                .map(c -> c.toString().trim())
                .filter(s -> !s.isEmpty()),
        (motionEventLeft, motionEventRight, entered) -> {
            boolean overrideFilter = motionEventLeft.getAction() == MotionEvent.ACTION_DOWN && motionEventRight.getAction() == MotionEvent.ACTION_DOWN;
            return overrideFilter || !isInappropriate(entered) ? entered : "BLOCKED";
        })
        .subscribe(s -> Log.i("ObservableCombineLatest", "s: " + s));