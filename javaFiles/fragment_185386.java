PlanetaryBody body = // ...

    body.asStar().ifPresent(s -> {
        // body is a star
        s.shineBrightly();
    });