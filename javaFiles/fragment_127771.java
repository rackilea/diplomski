public void sendDownstreamMessage(String jsonRequest) {
        Channel channel = channels.peekFirst();
        try {
            if (channel.connectionDraining) {
                synchronized (channels) {
                    channel = channels.peekFirst();
                    if (channel.connectionDraining) {
                        channels.addFirst(connect());
                        channel = channels.peekFirst();
                    }
                }
            }
            channel.send(jsonRequest);
        } catch (Exception e) {
            logger.error("Message not sent. Error in connecting :", e);
        }
    }