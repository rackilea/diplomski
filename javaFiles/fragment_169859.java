List<Integer> input = Arrays.asList(5, 2, 2, 5, 13);
List<Integer> list = new ArrayList<>();
for(Integer n : input) {
    if(!list.isEmpty() && Math.abs(list.get(list.size()-1)-n) < 2)
        list.set(list.size()-1, list.get(list.size()-1)+n);
    else
        list.add(n);
}
System.out.println(list);