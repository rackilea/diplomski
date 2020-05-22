return bs.stream()
        .filter( b -> b instanceof R)
        .map(b -> (R) b)
        .flatMap(r -> r.getB().stream()
                .filter(cObject -> cObject instanceof C)
                .map(cObject -> ((C) cObject).getV())
                .filter(vObject -> vObject instanceof V)
                .map(v -> r.getXyz())
        ).findFirst().orElse(null);