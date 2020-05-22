Single<List<Pair<Data,Detail>>> dataSingle = api.getList()
    .toFlowable()
    .flatMap(Flowable::fromIterable) // Convert the list to single emissions
    .flatMap(data -> {
            // Make api call to get details 
            return api.getDetails(data.getId())
                .flatMap(dataDetails -> {
                    return Flowable.just(Pair.create(data,dataDetail));
                });
        }).toList();