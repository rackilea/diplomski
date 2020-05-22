long lastPollTime = Optional.ofNullable(object).map(o -> o.getTime()).orElse(0L);

long lastPollTime = Optional.ofNullable(object).map(YouObjectClass::getTime).orElse(0L);

long lastPollTime = Optional.ofNullable(object).isPresent() ? object.getTime() : 0;

long lastPollTime = object != null ? object.getTime() : 0;