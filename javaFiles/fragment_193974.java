public static Articles getInstance() { 
    if (instance == null) {
        instance = new Articles();
    }
    logger.debug("Instance getInstance " + instance.getId());
    return instance;
}