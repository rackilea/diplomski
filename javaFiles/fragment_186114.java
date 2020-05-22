Stream.iterate(0, n -> n + 1).map(i -> {
       try {
           return req.substring(numberOfRetry - i);
       } catch (Exception e) {
           err.add(e);
       }
       return null;
})
.filter(Objects::nonNull)
.limit(1)
.findFirst()
.orElse("Exception");