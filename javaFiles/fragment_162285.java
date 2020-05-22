boolean working = true;
int openOptions  = CMQC.MQOO_INQUIRE + CMQC.MQOO_FAIL_IF_QUIESCING;
int depth = 0;
MQQueueManager qm = null;
MQQueue q = null;

try
{
   qm = new MQQueueManager("MQA1");

   while (working)
   {
      try
      {
         q = qm.accessQueue("TEST.Q1", openOptions);
         depth = q.getCurrentDepth();
//         (do something with depth)
      }
      catch (MQException e)
      {
         System.out.println("CC = " + e.completionCode + " : RC=" + e.reasonCode);
         System.out.println(e.getLocalizedMessage() );
         working = false;
      }
      finally
      {
         if (q != null)
         {
            q.close();
            q = null;
         }
      }

      try
      {
         if (working)
            Thread.sleep(10*1000); // time in milliseconds
      }
      catch (InterruptedException ie) {}
   }
}
catch (MQException e)
{
   System.out.println("CC = " + e.completionCode + " : RC=" + e.reasonCode);
   System.out.println(e.getLocalizedMessage() );
}
finally
{
   try
   {
      if (q != null)
         q.close();
   }
   catch (MQException e)
   {
      System.out.println("CC = " + e.completionCode + " : RC=" + e.reasonCode);
      System.out.println(e.getLocalizedMessage() );
   }

   try
   {
      if (qm != null)
         qm.disconnect();
   }
   catch (MQException e)
   {
      System.out.println("CC = " + e.completionCode + " : RC=" + e.reasonCode);
      System.out.println(e.getLocalizedMessage() );
   }
}