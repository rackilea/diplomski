Map<String, List<BoMLine>>
    filtered = materials.entrySet()
                        .stream()
                        .filter(a->a.getValue()
                                    .stream()
                                    .anyMatch(l->MaterialDao.findMaterialByName(l.getMaterial())))
                        .collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));