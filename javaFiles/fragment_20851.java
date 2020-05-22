Integer array[] = {1,2,3,3,4,5,6,6,7,8,8,10,10,11,12,13};

//Convert the array to a list.
List<Integer> list = Arrays.stream(array).collect(Collectors.toList());

//Use a Set in order to build the collection of unique values.
Set<Integer> uniqueValues = new HashSet<>(list);

//Remove each unique value once from the original list.
uniqueValues.stream().forEach(list::remove);

//Re-compute unique values of the resulting list and display them.
new HashSet<>(list).forEach(System.out::println);