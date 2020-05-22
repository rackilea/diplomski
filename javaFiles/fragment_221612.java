MQGetMessageOptions gmo = new MQGetMessageOptions();
gmo.options = CMQC.MQGMO_WAIT + CMQC.MQGMO_FAIL_IF_QUIESCING;
gmo.waitInterval = 5000;  // wait up to 5 seconds
MQMessage receiveMsg = null;
boolean getMore = true;

while(getMore)
{
   receiveMsg = new MQMessage();

   try
   {
      // get the message on the queue
      queue.get(receiveMsg, gmo);

      /*
       * Now go do something with the message
       */
   }
   catch (MQException e)
   {
      if ( (e.completionCode == CMQC.MQCC_FAILED) &&
           (e.reasonCode == CMQC.MQRC_NO_MSG_AVAILABLE) )
      {
         // No message - loop again
      }
      else
      {
         System.out.println("MQException: " + e.getLocalizedMessage());
         System.out.println("CC=" + e.completionCode + " : RC=" + e.reasonCode);
         getMore = false;
      }
   }
   catch (IOException e)
   {
      System.out.println("IOException:" +e.getLocalizedMessage());
   }
}