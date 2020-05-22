try {
   ... Code
} catch (JmsException je) {
    logger.error("Error when transfering message: '{}'.",message,e);
    throw je;
}