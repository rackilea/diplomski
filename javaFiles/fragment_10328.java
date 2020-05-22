package com.billybobbain.android.someapp;
import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {

   public static final String APP_NAME = "SomeApp";  

   private DatabaseHelper dataHelper;   

   @Override
   public void onCreate() {
      super.onCreate();
      Log.d(APP_NAME, "APPLICATION onCreate");
      this.dataHelper = new DatabaseHelper(this);      
   }

   @Override
   public void onTerminate() {
      Log.d(APP_NAME, "APPLICATION onTerminate");      
      super.onTerminate();      
   }

   public DatabaseHelper getDataHelper() {
      return this.dataHelper;
   }

   public void setDataHelper(DatabaseHelper dataHelper) {
      this.dataHelper = dataHelper;
   }
}