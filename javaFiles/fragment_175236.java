int Method1() throws Exception 
        {
          try
          {
            some file handling Code
          }
          Catch(FileNotFoundException ex){
          throw new MyException();// if you want to throw checked one otherwise below
          throw new RunTimeException();// for unchecked ones

         }
        }