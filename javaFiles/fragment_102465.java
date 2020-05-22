List<String> entries = x.getEntry.stream()
       .filter(e -> e != null)
       .flatMap(e -> Arrays.asList(
         e.getContent().getProperties().getPostcodes().split(",")).stream()
       )
       .collect(Collectors.toList());