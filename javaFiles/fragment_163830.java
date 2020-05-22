int finalAttempts = attempts;
Certificate certificate = Observable.range(1, attempts)
        .delay(3, TimeUnit.SECONDS)
        .filter(integer -> {
            order.update();
            return order.getStatus() == Status.VALID;
        })
        .map(integer -> {

            // do your stuff

        }).toBlocking().first();