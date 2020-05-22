CloudSolrClient client = null;
    try {
        client = new CloudSolrClient(zkClientUrl);
        client.setDefaultCollection(collectionName);
        m_logger.info("Explicit optimize of collection " + collectionName);
        long optimizeStart = System.currentTimeMillis();
        UpdateResponse optimizeResponse = client.optimize();

        for (Object object : optimizeResponse.getResponse()) {
            m_logger.info("Solr optimizeResponse" + object.toString());
        }
        if (optimizeResponse != null) {
            m_logger.info(String.format(
                    " Elapsed Time(in ms) - %d, QTime (in ms) - %d",
                    optimizeResponse.getElapsedTime(),
                    optimizeResponse.getQTime()));
        }
        m_logger.info(String.format(
                "Time spent on Optimizing a collection %s :"
                        + (System.currentTimeMillis() - optimizeStart)
                        / 1000 + " seconds", collectionName));
    } catch (Exception e) {
        m_logger.error("Failed during explicit optimize on collection "
                + collectionName, e);
    } finally {
        if (client != null) {
            try {
                client.close();
            } catch (IOException e) {
                throw new RuntimeException(
                        "Failed to close CloudSolrClient connection.", e);
            }
            client = null;
        }
    }