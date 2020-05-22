Article article = articleRepository.findById(id).get();
List<AWS_entity> aws_entitiesList = article.getAws().getEntities();

//a function that returns your predicates
Function<List<String>, Predicate<AWS_entity>> predictateFunction = 
        list -> aws -> article.getTitle().contains(aws.getName())
                        && list.stream()
                        .anyMatch(category -> aws.getCategory.equals(category));

return aws_entitiesList.stream()
        .filter(predictateFunction.apply(Arrays.asList("TITLE")))
        .max(Comparator.comparing(AWS_entity::getCount))
        .or(() -> aws_entitiesList.stream()
                    .filter(predictateFunction.apply(
                             Arrays.asList("COMMERCIAL_ITEM")))
                    .findFirst()
        )
        .or(() -> aws_entitiesList.stream()
                    .filter(predictateFunction.apply(
                             Arrays.asList("ORGANIZATION", "OTHER")))
                    .findFirst()
        )
        .map(entity -> entity.getName())
        .orElse("none identified");