try {
    processAFile();
} catch (Exception e) { // Just catch them all.
    logger.error(e);
    logger.error("log any important information here.");
    throw new RuntimeException("We were unable to process your file.");
}