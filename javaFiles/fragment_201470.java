Optional<Boolean> op = Optional.ofNullable(primaryDTO)
            .flatMap(x -> Optional.ofNullable(x.getSecondaryDTOs()))
            .map(x -> x.stream()
                    .filter(Objects::nonNull)
                    .flatMap(y -> y.getSecondaryCategoryDTOs().stream())
                    .map(SecondaryCategoryDTO::isStatus)
                    .anyMatch(z -> z == true)); 

if(op.isPresent()){
    // do your work
}