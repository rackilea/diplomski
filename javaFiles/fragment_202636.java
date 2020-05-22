Map<Long, Set<Long>> map2 = new HashMap<>();
    items.forEach(x -> map2.merge(
            x.getCategory(),
            x.getContainers(),
            (left, right) -> {
                left.addAll(right);
                return left;
            }));