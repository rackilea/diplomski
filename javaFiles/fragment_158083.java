Function<namesDAO, String> classifier2 = genericDAO::SOME_DYNAMIC_FIELD;

Map<String,Map<String,Long>> namesCountersMap =
        events.stream().collect(
            Collectors.groupingBy(
                namesDAO::getName,
                Collectors.groupingBy(
                    classifier2,
                    Collectors.counting())
            )
        );