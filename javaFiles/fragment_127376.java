List<ValueObject> values = Arrays.asList(new ValueObject(1, 2.0),
                                         new ValueObject(2, 2.0),
                                         new ValueObject(3, 3.0),
                                         new ValueObject(4, 4.0),
                                         new ValueObject(5, 4.0),
                                         new ValueObject(6, 4.0));
Map<Double, IntSummaryStatistics> groupedValues = values.stream()
                                                        .collect(Collectors.groupingBy(ValueObject::getValue,
                                                                                       Collectors.summarizingInt(ValueObject::getId)));

List<GroupedObject> groupedObjects = groupedValues.entrySet()
                                                  .stream()
                                                  .map(groupedValue -> new GroupedObject(groupedValue.getValue().getMin(),
                                                                                  groupedValue.getValue().getMax(),
                                                                                  groupedValue.getKey()))
                                                  .collect(Collectors.toList());
System.out.println(groupedObjects);