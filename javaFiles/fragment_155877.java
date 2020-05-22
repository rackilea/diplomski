@Override
public void saveES(List<Document> listDocs) {
    Seq<Document> root = seq(listDocs).filter(
            it -> ((Integer) it.get("currstatus") == 0) && ((Integer) it.get("aolevel") == 1)
    );

    root
            .leftOuterJoin(
                    seq(listDocs).filter(level_2 -> isNull(level_2.get("currstatus")) || ((Integer) level_2.get("currstatus") == 0)),
                    (a, b) -> checkObjects(a, b)
            )
            .leftOuterJoin(
                    seq(listDocs).filter(level_3 -> isNull(level_3.get("currstatus")) || ((Integer) level_3.get("currstatus") == 0)),
                    (a, b) -> checkObjects(a.v2, b)
            )
            .map(a -> a.v1.concat(a.v2))
            .leftOuterJoin(
                    seq(listDocs).filter(level_4 -> isNull(level_4.get("currstatus")) || ((Integer) level_4.get("currstatus") == 0)),
                    (a, b) -> checkObjects(a.v3, b)
            )
            .map(a -> a.v1.concat(a.v2))
            .leftOuterJoin(
                    seq(listDocs)
                            .filter(level_5 -> isNull(level_5.get("currstatus")) || (nonNull(level_5.get("currstatus")) && (Integer) level_5.get("currstatus") == 0)),
                    (a, b) -> checkObjects(a.v4, b)
            )
            .map(a -> a.v1.concat(a.v2))
            .leftOuterJoin(
                    seq(listDocs).filter(level_6 -> isNull(level_6.get("currstatus")) || ((Integer) level_6.get("currstatus") == 0)),
                    (a, b) -> checkObjects(a.v5, b)
            )
            .map(a -> a.v1.concat(a.v2))
            .leftOuterJoin(
                    seq(listDocs).filter(level_7 -> isNull(level_7.get("currstatus")) || ((Integer) level_7.get("currstatus") == 0)),
                    (a, b) -> checkObjects(a.v6, b)
            )
            .map(a -> a.v1.concat(a.v2))
            .parallel()
            .distinct()
            .forEach(it -> {
                List<Document> objects1 = (List<Document>) it.toList();
                String full = objects1.stream()
                        .filter(Objects::nonNull)
                        .map(doc -> String.join(" ", doc.getOrDefault("shortname", "") + ".", (String) doc.get("formalname")))
                        .collect(Collectors.joining(" "));

                List<Document> objects2 = (List<Document>) it.toList();
                List<Entry> entryList = objects2.stream()
                        .filter(Objects::nonNull)
                        .map(doc -> Entry.builder()
                                .aoid((String) doc.getOrDefault("aoid", ""))
                                .aoGuid((String) doc.getOrDefault("aoguid", ""))
                                .code((String) doc.getOrDefault("code", ""))
                                .offName((String) doc.getOrDefault("offname", ""))
                                .parentGuid((String) doc.getOrDefault("parentguid", ""))
                                .shortName((String) doc.getOrDefault("shortname", ""))
                                .aoLevel((Integer) doc.getOrDefault("aolevel", ""))
                                .postalCode((String) doc.getOrDefault("postalcode", ""))
                                .build())
                        .collect(Collectors.toList());
                log.info(full);
                Address address = new Address(full, entryList);
                searchService.save(address);
            });
}