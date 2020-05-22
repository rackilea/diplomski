PGNotification[] notifications = pgconn.getNotifications();
SerializableNotification[] serializableNotifications = new SerializableNotification[notifications.length];
for(int i = 0; i < notifications.length; i++) {
   PGNotification notif = notifications[i];
   serializableNotifications[i] = new SerializableNotification(notif.getName(), notif.getPID, notif.getParameter());
}