Instant latest = instants.get(instants.size() - 1);
        Instant newInstant = latest.plus(amount);
        if (newInstant.isBefore(latest)) {
            // The amount was negative; do whatever handling of the situation you need
        } else {
            instants.add(newInstant);
        }