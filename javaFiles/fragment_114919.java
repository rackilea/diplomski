Hashtable<String, Object> properties;
      properties = new Hashtable<String, Object>();
      properties.put("hostname", "replyqmhost");
      properties.put("port", new Integer(1414));
      properties.put("channel", "REPLYQM.SVRCONN");
      properties.put(MQConstants.USE_MQCSP_AUTHENTICATION_PROPERTY,true);
      properties.put(MQConstants.USER_ID_PROPERTY, "<user id>");
      properties.put(MQConstants.PASSWORD_PROPERTY, "<password>");

      /**
        * Connect to a queue manager 
        */
      MQQueueManager queueManager = new MQQueueManager("replyQM", properties);