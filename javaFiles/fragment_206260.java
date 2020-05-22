final Integer radix = 36; // that's 0-9 A-Z
final Double limit = Math.pow(radix.doubleValue(), 3.0 /* max number of 'chars' */);
Stream.iterate(0, i -> i+1)
        .map(i -> Integer.toString(i, radix))
        .map(s -> String.format("000%S", s)
                        .substring(s.length())) // leading 0, uppercase
        .limit(limit.longValue())
        .forEach(System.out::println);