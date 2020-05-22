Map<String, GroupedDataObject> map =
    list.stream()
        .collect(Collectors.toMap(SomeData::valueToGroupBy,
                                  d -> {
                                     List<Object> l = new ArrayList<>();
                                     l.add(d.data());
                                     return new GroupedDataObject(d.valueToGroupBy(), l);
                                  },
                                  (g1,g2) -> {
                                      g1.datas().addAll(g2.datas());
                                      return g1;
                                  }));