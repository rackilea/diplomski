class DBFactoryController {
   private static DBFactoryController instance = null;
   public DBFactoryController getInstance() {
      if (instance == null) {
         instance = new DBFactoryController();
      }
      return instance;
   }

   public DBFactoryController() {
      buildCache();
      notifcation.startPushManager();
   }
}