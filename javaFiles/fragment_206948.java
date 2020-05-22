List<A> aList = ...;
List<A> aListResult = 
    aList.stream()
        .filter(a -> a.getStatus().equals("Active"))
        .filter(a -> a.bList.stream().allMatch(b -> b.getStatus().equals("Active")))
        .collect(Collectors.toList());