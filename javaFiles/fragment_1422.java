Collectors.toMap(
       MappingEntry::getMilestone,
       x -> {
           List<MappingEntry> list = new ArrayList<>();
           list.add(x);
           return list;
       },
       (left, right) -> {
            left.addAll(right);
            return left;
       },
       HashMap::new

)