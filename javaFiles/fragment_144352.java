public static final String INTENT_ACTION = "io.test.TEST";
   public static final String INTENT_EXTRA  = "someData";

   Intent intent = new Intent();
   intent.setAction(INTENT_ACTION);
   intent.putExtra(INTENT_EXTRA,"test");
   sendBroadcast(intent);