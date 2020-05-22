try {
     Class < ? > libcore = Class.forName("libcore.io.Libcore");
     if (libcore == null) {
      Log.w(TAG, "Cannot find libcore.os.Libcore;");
      //                return;
     } else {
      final Object os = Class.forName("libcore.io.Libcore").getField("os").get(null);

      Method method = os.getClass().getMethod("setenv", String.class, String.class, boolean.class);
      method.invoke(os, "value", "test", true);



     }
    } catch (Exception e) {
     Log.w("Sam1", Log.getStackTraceString(e));
     Log.w("Sam1", e.getMessage());
    }