new ArrayList<>(assemblies.stream()
                          .collect(toMap(Assembly::getAssemblyCode, o -> o,
                                         (a, b) -> new Assembly(a.getAssemblyCode(),
                                                                a.getAssemblyQty() + b
                                                                    .getAssemblyQty()),
                                         LinkedHashMap::new)
                          )
                          .values());