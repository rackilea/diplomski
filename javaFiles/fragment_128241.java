return paginationResult.stream()
        .collect(Collectors.groupingBy(
                SomeBean::getK,
                flatMapping(
                    someBean -> someBean.getV().stream(),
                    Collectors.toList())));