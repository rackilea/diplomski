public void writeToHoldQueue(String message) throws IOException,
            MQException {
        MQMessage mqMessage = new MQMessage();
        mqMessage.format = MQConstants.MQFMT_STRING;
        mqMessage.messageType = MQConstants.MQMT_DATAGRAM;

        mqMessage.writeString(message);
        holdQueue.getQueue().put(mqMessage, putMsgOpts);
    }