double parallel = Arrays.stream(i)
                        .parallel()           // <-- before filter
                        .filter(si -> si > 5) // <-- shorter
                        .asDoubleStream()     // <-- not boxing
                        .reduce(Math::atan2)
                        .getAsDouble();