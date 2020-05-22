public static Brand findBy(String value, Function<Brand, String> extractor) {
      return Arrays.stream(Brand.values())
            .filter(brand -> extractor.apply(brand).equalsIgnoreCase(value))
            .findFirst()
            .orElse("Either a default or throw exception here");
   }