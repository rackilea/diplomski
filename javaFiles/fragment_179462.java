double[] manyDoubles = ....
DoubleSummaryStatistics dss =
            DoubleStream.of(manyDouble)
                        .parallel()// do stuff in parallel using all the CPUS
                        .filter(x -> x >= 1)
                        .map(x -> x * x)
                        .summaryStatistics();