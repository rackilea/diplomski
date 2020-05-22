MQQueueConnectionFactory cf = new MQQueueConnectionFactory();
  ExceptionListener exceptionListener = new ExceptionListener(){
                @Override
                public void onException(JMSException e) {
                    System.out.println(e);
                    if(e.getLinkedException() != null)
                        System.out.println(e.getLinkedException());
                }
            };
 MQQueueConnection connection = (MQQueueConnection) cf.createQueueConnection();
 connection.setExceptionListener(exceptionListener);