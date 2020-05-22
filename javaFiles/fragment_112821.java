Instant epoch = OffsetDateTime.of(1900, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant();

    BigInteger timeStamp = new BigInteger("C50204ECEC42EE92", 16);

    // To get the whole part and the fraction right, divide by 2^32
    double secondsSince1900 = timeStamp.doubleValue() / 0x1_0000_0000L;

    // Convert seconds to nanos by multiplying by 1 000 000 000
    Instant converted = epoch.plusNanos(Math.round(secondsSince1900 * 1_000_000_000L));
    System.out.println(converted);