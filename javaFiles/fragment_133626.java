try
{
   int oo = MQC.MQOO_INPUT_SHARED + MQC.MQOO_FAIL_IF_QUIESCING;
   MQQueue q = queueManager.accessQueue("qName1",oo);
   MQGetMessageOptions gmo = new MQGetMessageOptions();
   gmo.options = MQC.MQGMO_NO_WAIT + MQC.MQGMO_FAIL_IF_QUIESCING;
   q.get(msg, gmo);
}
catch (MQException e)
{
   System.err.println(e.getLocalizedMessage() );
   System.err.println("CC = " + e.completionCode + " - RC = " + e.reasonCode);
}