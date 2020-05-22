MQPutMessageOptions pmo = new MQPutMessageOptions();
pmo.options = CMQC.MQPMO_FAIL_IF_QUIESCING;

MQMessage sendmsg = new MQMessage();
sendmsg.messageId    = CMQC.MQMI_NONE;
sendmsg.correlationId= CMQC.MQCI_NONE;
sendmsg.format       = CMQC.MQFMT_STRING;
sendmsg.messageType  = CMQC.MQMT_DATAGRAM;
sendmsg.expiry       = timeToLive; // expiry is in tenths of a second
sendmsg.write(msg.getBytes());

outQ(sendmsg, pmo);