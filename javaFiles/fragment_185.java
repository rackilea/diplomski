long secondsSince1Jan1900 = Integer.toUnsignedLong(time);

long differenceBetweenEpochs = 2208988800L;

long secondsSince1Jan1970 = secondsSince1Jan1900 - differenceBetweenEpochs;

Instant instant = Instant.ofEpochSecond(secondsSince1Jan1970);