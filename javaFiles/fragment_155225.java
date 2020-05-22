ArrayList<IncomeChannelCategoryMap> list = entityManager.createQuery(criteriaQuery).getResultList();

List<IncomeChannelCategoryMap> finalList = new ArrayList<>(list.stream().collect(
                 Collectors.toMap(IncomeChannelCategoryMap::getIncomeChannelCode, Function.identity(), (IncomeChannelCategoryMap i1, IncomeChannelCategoryMap i2) -> {
                     i1.setLogicalUnitIdent(i1.getLogicalUnitIdent()+","+i2.getLogicalUnitIdent());
                     return i1;
                 })).values());

 return finalList;