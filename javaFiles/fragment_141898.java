public static Session ss=null;
     public static Transaction t= null;

    public static boolean insertdata(Loginmodel e1)
     {
         try
         {
             ss = Regiutil.getsessionfactory().openSession();
             t= ss.beginTransaction();
             ss.save(e1);
             t.commit();
             return true;
         }
         catch (Exception e) 
         {
             return false;
         }
         finally
         {
             ss.close();
         }
     }