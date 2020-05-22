articleSet.stream()
           .filter(Article::isSelected)
           .flatmap(ar -> ar.getKeywordsList().stream())
           .collect(Collectors.groupingBy(
                   Function.identity(),
                   Collectors.counting()));