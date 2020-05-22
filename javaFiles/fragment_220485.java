return availableOrderIds.stream()
        .map(this::tryToReserve)
        .filter(this::successful)
        .findFirst()
        .map(this::withReservationIdFrom)
        .orElse(0L); // assumed as default value