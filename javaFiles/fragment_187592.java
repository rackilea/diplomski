MQGetMessageOptions gmo = new MQGetMessageOptions();   
gmo.waitInterval = 1000;
gmo.options = MQGMO_WAIT;
gmo.options += MQGMO_FAIL_IF_QUIESCING;
gmo.options += MQGMO_SYNCPOINT;

MQPutMessageOptions pmo = new MQPutMessageOptions();
pmo.options += MQPMO_SYNCPOINT;

// create message instance
MQMessage message = new MQMessage();
message.correlationId = MQCI_NONE;
message.messageId = MQMI_NONE;

// read message
queueA.get(message, gmo);

// write message
queueB.put(message, pmo);

// commit transaction
qmgr.commit();