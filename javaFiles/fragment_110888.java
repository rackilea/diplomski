Set<String> roots = orders
            .stream()
            .filter(value -> value.getPreviousOrderRef() == null || 
                             value.getPreviousOrderRef().isEmpty())
            .map(MyOrder::getOrderNum)
            .collect(Collectors.toSet());

List<MyOrderMapped> orderRoots = mappedById.values()
            .stream()
            .filter(current -> roots.contains(current.getOrderNum()))
            .collect(Collectors.toList());