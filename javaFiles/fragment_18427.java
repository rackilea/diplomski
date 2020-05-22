private Collection<Order> getCustomerOrders(CustomerKey customerKey)
{
  List<Order> orders = new ArrayList<>();

  MapService mapService = node.getClusterService().getNodeEngine().getService(MapService.SERVICE_NAME);

  RecordStore recordStore = mapService.getRecordStore(node.getPartitionService().getPartitionId(customerKey), "orders");

  for (Data key : recordStore.keySet())
  {
    OrderKey orderKey = mapService.getSerializationService().toObject(key);

    if (customerKey.equals(orderKey.getCustomerKey()))
    {
      orders.add(mapService.getSerializationService().toObject(recordStore.get(key)));
    }
  }

  return orders;
}