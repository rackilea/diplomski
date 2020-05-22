List<Integer> voIds = FluentIterables.from(valueObjects)
  .transform(valueObjectIdGetter())
  .toSortedList(intComparator());
List<Integer> dtoIds = FluentIterables.from(dtos)
  .transform(dtoIdGetter())
  .toSortedList(intComparator());
return voIds.equals(dtoIds);