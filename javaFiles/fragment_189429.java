class OrderManager {
   private OrderDAO oDao;
   private NotificationDao nDao;

   public saveOrder(OrderDTO o) {
      Long orderId = oDao.save(o);
      NotificationDTO n = new NotificationDTO();
      n.setType(NotificationType.ORDER_CREATED);
      n.setEntityId(orderId);
      nDao.save(n);
   }
}