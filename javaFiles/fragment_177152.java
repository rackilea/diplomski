api.call1()
    .flatMap( 
        { a -> api.call2(a) },
        { a, b -> new Pair(a, b) }
    )
    .flatMap { pair-> api.call3(pair.first, pair.second) }