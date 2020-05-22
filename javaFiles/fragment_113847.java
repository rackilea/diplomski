Observable<List<Cal>> cal = Calbackend.get(customerid)
            .onErrorReturn(new Func1<Throwable, Cal>() {
                @Override
                public Cal call(Throwable throwable) {
                    // Return something in the error case
                    return null;
                }
            })
            .toList();