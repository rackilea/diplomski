List<List<String>> main = new ArrayList<>();
List<String> l1 = Arrays.asList("1", "2");
List<String> l2 = Arrays.asList("3", "4");
main.add(l1);
main.add(l2);
List<String> ans = main.stream()
                       .flatMap(list -> list.stream())
                       .collect(Collectors.toList());
System.out.println(ans);