Hashtable mqProps = new Hashtable();
       mqProps.Add(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES_MANAGED);
       mqProps.Add(MQC.HOST_NAME_PROPERTY, "<yourhost>");
       mqProps.Add(MQC.PORT_PROPERTY, port);
       mqProps.Add(MQC.CHANNEL_PROPERTY, "<svrconn channel name>");

       MQQueueManager qmConn = new MQQueueManager("replyQM", mqProps);