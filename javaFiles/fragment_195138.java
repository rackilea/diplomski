public String read(){
          String temp="";
          try{
             FileInputStream fin = openFileInput(file);
             int c;

             while( (c = fin.read()) != -1)
             {
                temp = temp + Character.toString((char)c);
             }
          }
          catch(Exception e)
          {

          }
          Log.d("INSIDE READ FUNC", "temp have "+temp);
        return temp;
       }