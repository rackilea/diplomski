mApi.callA(someArgs)
        // ...
        .flatMap(response -> processA(response))
        .flatMap(response -> {
              return Observable.zip(
                    callB(response),
                    callC(response),
                    (rA,rB) -> {
                          // or just return a new Pair<>(rA, rB)
                          return combineAPlusB(rA,rB)
                    }
              )
        })
        // ...
        .subscribe(this::allDone this::failure);