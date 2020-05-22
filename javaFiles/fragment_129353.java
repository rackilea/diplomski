List<YourObject> collect = activities
              .stream()
              .collect(Collectors.groupingBy(
                        YourObject::getId, 
                        Collectors.maxBy(Comparator.comparing(YourObject::getCreatedDate))))
              .entrySet()
              .stream()
              .map(e -> e.getValue().get())
              .collect(Collectors.toList());