public List<Notification> getNotifications(Long id){

//Start the transaction

//do some error handling and transaction rollback
User user = session.createQuery("from User where id = :id").setParameter("id", id).uniqueParameter();

List<Notification> notifications = new ArrayList<Notification>();
for (Notification notification : user.getNotifications()){
   if (notification.getDate.before(calendar.getTime()){
       notifications.add(notification);
   }
}
//commit the transaction
//close the session
return notifications;