try{
          guiChanged();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            AlertDialog alert =errormessage();
             alert.show(); //<<< show AlertDialog here
        }