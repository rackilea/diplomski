dirs
   .sort(Comparator.comparing(Dir::getS1)
                    .thenComparingInt(
                            d -> d.getS1().length() + d.getS2().length() + d.getS3().length())
                    .thenComparing(Dir::getS2)
                    .thenComparing(Dir::getS3));