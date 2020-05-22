Optional<List<String>> expectedRow = dataRecs
    .findFirst(row -> referencingValue.equals(row.get(refColIndex))));

if(expectedRow.isPresent()) {
    requiredColValueAndName.put(expectedRow.get().get(indexAndColNamePair.getKey()[1]),
                                indexAndColNamePair.getValue()[1]);
}