List<Timestamp> result = myDTOList
                .stream()
                .map(MyDTO::getProjReleaseDate)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());