Observable.interval(100, TimeUnit.MILLISECONDS)
        .take(1000)
         .subscribe(new Action1<Long>() {
          @Override public void call(Long timerValue) {

        }
        });