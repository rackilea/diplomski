BigDecimal timeStamp = new BigDecimal(new BigInteger("C50204ECEC42EE92", 16));

    // To get the whole part and the fraction right, divide by 2^32
    BigDecimal bit32 = new BigDecimal(0x1_0000_0000L);
    BigDecimal secondsSince1900 = timeStamp.divide(bit32);

    // Convert seconds to nanos by multiplying by 1 000 000 000; round to long
    long nanosSince1900 = secondsSince1900.multiply(new BigDecimal(TimeUnit.SECONDS.toNanos(1)))
            .setScale(0, RoundingMode.HALF_UP)
            .longValueExact();

    Instant converted = epoch.plusNanos(nanosSince1900);