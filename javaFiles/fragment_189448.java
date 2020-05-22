public void onException(JMSException exception)
      {
         try
         {
            connection.close();
         }
         catch (JMSException e)
         {
            logger.log(Level.INFO, "Connection Failed", e);
         }
      }