return bs.stream()
        .filter(b -> b instanceof R)
        .map(b -> (R) b)
        .filter(r -> r.getB()
                .stream()
                .anyMatch(c -> c instanceof C && ((C) c).getV() instanceof V)
        )
        .map(R::getXyz)
        .findFirst().orElse(null);