private static boolean differAtMostByOne(final String oldVal, final String newVal) {
    final double oldValAsDouble = Double.parseDouble(oldVal);
    final double newValAsDouble = Double.parseDouble(newVal),

    final double difference = Math.abs(oldValAsDouble - newValAsDouble);

    final double compareTo = 1.0;
    final double precision = 0.000001;
    final boolean differByAtMostOne = difference <= compareTo + precision;

    return differByAtMostOne;
}