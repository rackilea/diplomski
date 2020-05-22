File f=new File("batches");
      if(!f.exists())
      {
        f.mkdir();
      }
      else{
          System.out.println("Already present!");
      }