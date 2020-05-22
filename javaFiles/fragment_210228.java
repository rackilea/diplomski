public static List<Integer> populateListStream2(int numberOfElements){
    return IntStream.range(0,numberOfElements)
                    .map(e -> random.nextInt(numberOfElements/10))
                    .boxed()
                    .collect(Collectors.toList());
}