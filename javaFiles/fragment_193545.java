try {
   ... Code
} catch (JMSException je) {
    logger.error("Error when transfering message: '{}'.",message,e);
    throw JmsUtils.convertJmsAccessException(je);
}