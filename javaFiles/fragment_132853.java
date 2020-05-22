Map<Integer, List<Integer>> map = initialList
                .stream()
                .collect(Collectors
                        .toMap(lv1 -> lv1.idLevel1,
                                lv1 -> lv1.level2list
                                        .stream()
                        .flatMap(lv2 -> lv2.level3list
                                .stream())
                        .map(lv3 -> lv3.idLevel3)
                        .collect(Collectors.toList())));