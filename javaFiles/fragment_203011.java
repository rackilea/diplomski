List<Integer> list = new ArrayList<>();

for(String str : largeString.split("(?<=\\G.{8})"))
    list.add(Integer.parseInt(str, 2));

System.out.println(list);  // Outputs [78, 187, 96, 17, 21]