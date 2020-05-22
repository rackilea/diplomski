return availableOrderIds.stream()
        .map(this::tryToReserve)
        .filter(res -> !res.isEmpty())
        .findFirst()
        .map(res -> res.get(0).getReservationId())
        .orElse(0L);