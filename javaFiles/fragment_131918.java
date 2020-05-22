public static List<Triplet> returnPythogoreanTriplets(int num) {
    return IntStream.rangeClosed(1, num).boxed().flatMap(hyp -> 
        IntStream.range(1, hyp).boxed().flatMap(side1 -> 
            IntStream.rangeClosed(1, side1).mapToObj(side2 -> new Triplet(side2, side1, hyp))
        )
    )
    .filter(Triplet::isPythagorean)
    .collect(Collectors.toList());
}