try
   {
       message= new String(message.getBytes("UTF-8"),"ISO-8859-1");
   }
   catch (UnsupportedEncodingException e1)
   {
       // TODO Auto-generated catch block
       e1.printStackTrace();
   }