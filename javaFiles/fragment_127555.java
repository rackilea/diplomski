if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
    Intent start = new Intent(context, MainMenu.class);
    start.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
-        context.startActivity(new Intent(context, MainMenu.class));
+        context.startActivity(start);
    }else if(intent.getAction().equals("com.example.remind.STOP")){