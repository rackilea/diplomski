List<List<Double>> lists = ...;

// ensure all lists are same size, and get size
int[] sizes = lists.stream().mapToInt(List::size).distinct().toArray();
if (sizes.length != 1)
    throw ...
int size = sizes[0];

double[] sums =
    IntStream.range(0, size)
             .mapToDouble(i -> lists.stream().mapToDouble(list -> list.get(i)).sum())
             .toArray();