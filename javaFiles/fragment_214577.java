String getAndroidId(Context ctx) {
       String[] params = { ID_KEY };
       Cursor c = ctx.getContentResolver()
               .query(URI, null, null, params, null);
       try{

       if (!c.moveToFirst() || c.getColumnCount() < 2){
           return null;
       }
       }catch(Exception e){
           return null;
       }

       try {
           Toast.makeText(ctx, Long.toHexString(Long.parseLong(c.getString(1))), 500).show();
           System.out.println("android id  " + Long.toHexString(Long.parseLong(c.getString(1))));

           return Long.toHexString(Long.parseLong(c.getString(1)));

       } catch (NumberFormatException e) {
           return null;
       }
   }