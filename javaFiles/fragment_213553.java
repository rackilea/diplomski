movieReservations
    .groupBy(MovieReservation::movieId)
    .flatMap(idFlux -> idFlux
        .collectList()
        .map(listOfReservations ->
            new MovieInformation(idFlux.key(), listOfReservations)
        )
    );