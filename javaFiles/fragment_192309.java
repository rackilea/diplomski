Intent intent = new Intent();
intent.setClassName(
  "com.example.app1" /* your package which contains service */,
  "com.example.services.MessengerService" /* service name */
);

bindService(intent, mConnection, Context.BIND_AUTO_CREATE);