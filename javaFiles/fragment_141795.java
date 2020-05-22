Arrays.sort(dataArray, Comparator.comparing(d -> d.getPriority())); // sort

Arrays.stream(dataArray)
.peek(o -> System.out.println("SORT: " + o))
.map(d -> d.getOriginalURL(shortUrl))
.peek(o -> System.out.println("MAP: " + o))
.filter(u -> u != null && !u.isEmpty())
.peek(o -> System.out.println("FILTER: " + o))
.findFirst().orElse("");