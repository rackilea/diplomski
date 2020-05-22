try (final OutputStream os = httpExchange.getResponseBody()) {
                    IOUtils.copy(is, os, 128);
                } catch (IOException e) {
                    logger.warn("Error proxy data", e);
                    throw e;
                }