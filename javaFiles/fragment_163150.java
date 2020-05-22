Map<Character, Long> charValues = IntStream.range(0, chars.length)
                .boxed()
                .collect(Collectors.toMap(i -> chars[i], Long::valueOf));

long l =  line.chars()
        .mapToObj(i -> (char) i)
        .map(charValues::get)
        .reduce(0L, (a, b) -> a * chars.length + b);

System.out.println(l);
// prints "2842528454463293618"