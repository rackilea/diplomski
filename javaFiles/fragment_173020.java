Stream<A> result = 
       IntStream.range(0, d.length)
                .filter(cur -> d[cur] != null)
                .flatMap(cur -> IntStream.range(cur + 1, d.length)
                        .filter(nxt -> d[nxt] != null)
                        .filter(nxt -> d[cur].getB() == d[nxt].getB())
                        .map(i -> cur))
                .mapToObj(cur -> new A(d[cur].getB() * 0.5f));

d = Stream.concat(Arrays.stream(d), result)
          .toArray(A[]::new);