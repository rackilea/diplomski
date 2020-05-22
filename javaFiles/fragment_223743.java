private volatile Map<String, String> key_values = new HashMap<String,String>();

  ..rest of class 

   public void reloadConfig() {
      Map<String, String> tmp_map = new HashMap<String,String> ();
      // read  data from database

      this.key_values = tmp_map;
   }