Mono<Info> info = Mono.just(id)
                          .map(this::getInfo)
                          .subscribeOn(Schedulers.elastic());

    Mono<List<Detail>> detail= Mono.just(petitionRequest)
                                   .map(this.service::getDetails)
                                   .subscribeOn(Schedulers.elastic());

    Mono<Description> description = Mono.just(id)
                                        .map(this::callService)
                                        .subscribe(Schedulers.elastic());

    Mono.zip(info, detail, description)
        .map(this::map);

    private Generated map(Tuple3<Info, List<Detail>, Description> tuple3)
    {
        Info info = tuple3.getT1();
        List<Detail> details = tuple3.getT2();
        Description description = tuple3.getT3();

        // build output here
    }