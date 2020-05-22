Stream.of(filterAndMapValue(kv1, predicateForKV1, mapV1toV),
          filterAndMapValue(kv2, predicateForKV2, mapV2toV),
          filterAndMapValue(kv3, predicateForKV3, mapV3toV),
          …)
      .flatMap(Function.identity())
      .collect(Collectors.toMap(Entry::getKey, Entry::getValue));