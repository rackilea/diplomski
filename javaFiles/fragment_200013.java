Delivery delivery = null;
    T queue = null;

    //loop over, continuously retrieving messages
    while(true) {

        try {
            delivery = consumer.nextDelivery();
            queue = deserialise(delivery.getBody());
            process(queue);
            consumer.getChannel().basicAck(delivery.getEnvelope().getDeliveryTag(), false);

        } catch (ShutdownSignalException e) {
            logger.warn("Shutodwon signal received.");
            break;
        } catch (ConsumerCancelledException e) {
            logger.warn("Consumer cancelled exception: {}",e.getMessage());
            break;
        } catch (InterruptedException e) {
            logger.warn("Interuption exception: {}", e);
            break;
        } catch (IOException e) {
            logger.error("Could not ack message: {}",e);
            break;
        }
    }