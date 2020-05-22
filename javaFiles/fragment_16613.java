Double[] array = new Double[]{1d,2d,3d,4d,5d,6d,7d,8d,9d};
List<Double> list = new ArrayList<>(Arrays.asList(array));

for (int i = 0; i < array.length; i++) {

  double average = average(list);
  System.out.printf("Average A%d: %.1f, List: %s\n", (i+1), average, input);

  double furthest = furthest(list, average);
  list.remove(furthest);
}