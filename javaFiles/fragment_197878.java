try {
        retriever.call();
    } catch (Exception e) {
        String message = Logging.getMessage("layers.TiledImageLayer.ExceptionRetrievingResources", url.toString());
        Logging.logger().log(java.util.logging.Level.SEVERE, message, e);
    }