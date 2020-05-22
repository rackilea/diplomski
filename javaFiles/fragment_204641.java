IContainer container = IContainer.make();
    if (container.open(movie, IContainer.Type.READ, null) < 0) {
        throw new RuntimeException("Cannot open '" + movie + "'");
    }

    logger.info("# Duration (ms): " + ((container.getDuration() == Global.NO_PTS) ? "unknown" : "" + container.getDuration() / 100));
    logger.info("# File size (bytes): " + container.getFileSize());
    logger.info("# Bit rate: " + container.getBitRate());