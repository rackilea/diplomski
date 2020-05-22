validateLines(lines)
    .subscribeWith(new DisposableCompletableObserver() {
        @Override
        public void onComplete() {
            // if validation succeeds , on Complete is triggered
        }

        @Override
        public void onError(Throwable e) {
            // if any error happens , onError triggered, 
              if(e instanceof ValidationError){
                  // a validation error has happened
              }

        }
    })