public HashMap<String, LinkedList<OrderEntryModel>> processSegmentData(final List resultSet) {
    HashMap<String, LinkedList<OrderEntryModel>> orderEntriesMap = new HashMap<String, LinkedList<OrderEntryModel>>();

    for (final Object orderEntry : resultSet) {
        if (orderEntry instanceof OrderEntryModel) {
            String countryCode = null;

            final OrderModel order = ((OrderEntryModel) orderEntry).getOrder();

            if (order.getDeliveryAddress() != null) {
                countryCode = order.getDeliveryAddress().getCountry().getIsocode();
            }
            if (!orderEntriesMap.containsKey(countryCode)) {
                orderEntriesMap.put(countryCode, new LinkedList<OrderEntryModel>());
            }
            orderEntriesMap.get(countryCode).add((OrderEntryModel) orderEntry);                

        }

    }
    return orderEntriesMap;
}