orders.stream().forEach(order -> {
        MyOrderMapped current = mappedById.get(order.getOrderNum());
        order.getPreviousOrderRef().forEach(parentOrderNum -> {
            MyOrderMapped parent = mappedById.get(parentOrderNum);
            parent.getNextOrderRefs().add(current);
        });
    });