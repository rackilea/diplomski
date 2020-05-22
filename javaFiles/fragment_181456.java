public void send(Object data) {
        ObjectMessage obj = session.createObjectMessage();
        obj.setObject(data);
        try{
           producer.send(obj);

        }catch( JMSException jex){
          producer.close();
          session.close();
          connection.close();
          throw new EJBException( jex);
        }
    }