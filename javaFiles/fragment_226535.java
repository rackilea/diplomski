List<Integer>list1=Arrays.asList(1,2,3);
List<Integer>list2=Arrays.asList(4,5,6);
List<Integer>list3=Arrays.asList(7,8,9);
List<Integer>list4=Arrays.asList(10,0,-1);
List<Integer> newList = Stream.of(list1, list2, list3,list4)
                                      .flatMap(Collection::stream)
                                      .collect(Collectors.toList());       
 System.out.println(newList); // prints [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, -1]