List<List<Double>> list = Arrays.asList(Arrays.asList(1d, 2d, 3d),
                                        Arrays.asList(2d, 3d, 4d, 5d));

//the largest list size
int maxSize = list.stream().mapToInt(List::size).max().orElse(0);

//for each index in the final list, we calculate the average across "valid" lists
//i.e. lists that are large enough
List<Double> averages = IntStream.range(0, maxSize)
                        .mapToObj(i -> list.stream()
                                            .filter(sublist -> sublist.size() > i)
                                            .mapToDouble(sublist -> sublist.get(i))
                                            .average().getAsDouble())
                        .collect(toList());

//prints averages = [1.5, 2.5, 3.5, 5.0]
System.out.println("averages = " + averages);