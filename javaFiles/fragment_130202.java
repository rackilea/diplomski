private void RedFlashLight()
{
NotificationManager nm = ( NotificationManager ) getSystemService( 
NOTIFICATION_SERVICE );
Notification notif = new Notification();
notif.ledARGB = 0xFFff0000;
notif.flags = Notification.FLAG_SHOW_LIGHTS;
notif.ledOnMS = 100; 
notif.ledOffMS = 100; 
nm.notify(LED_NOTIFICATION_ID, notif);
// Program the end of the light :
mCleanLedHandler.postDelayed(mClearLED_Task, LED_TIME_ON );
}