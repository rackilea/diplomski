Map<Long, OrderCriteriaGroup> grouped = criteriaList.stream()
        .collect(Collectors.groupingBy(OrderCriteria::getOrderId,
                Collector.of(
                        OrderCriteriaGroup::new,
                        OrderCriteriaGroup::add,
                        OrderCriteriaGroup::merge)));