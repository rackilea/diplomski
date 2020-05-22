List<Integer> result = Stream.of(5, 2, 2, 5, 13).collect(ArrayList::new, (list, n) -> {
    if(!list.isEmpty() && Math.abs(list.get(list.size()-1)-n) < 2)
        list.set(list.size()-1, list.get(list.size()-1)+n);
    else
        list.add(n);
}, (l1, l2) -> {throw new UnsupportedOperationException();});
System.out.println(result);