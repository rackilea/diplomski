someObj0.setObjects2(
 Optional.ofNullable(entity.getObjects1())
.orElse(Coollections.emptyList()) // return original Object or singleton empty from Collections 
.stream()
.map(lambdaFunc)
.filter(Objects::nonNull) // add checking here
.collect(Collectors.toSet()));