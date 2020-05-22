class ComplexObj {
    private String id;
    ...
}

Map<Boolean, List<ComplexObj>> map = list1.stream()
            .collect(Collectors.partitioningBy(obj -> list2.stream()
                    .map(ComplexObj::getId)
                    .anyMatch(id -> id.equals(obj.getId()))));