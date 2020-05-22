if (!config.isOnlyMemory() && dataHead.inMemory >= config.memoryThreshold) {
         try {
             String prefix = config.getTempFilePrefix();
             String suffix = config.getTempFileSuffix();
             File dir = config.getTempDir();
             File tempFile = (dir == null)
                     ? File.createTempFile(prefix, suffix) // here your code crashes
                     : File.createTempFile(prefix, suffix, dir);
             LOGGER.fine("Created temp file = "+tempFile);
             dataHead.dataFile = new DataFile(tempFile);
         } catch(IOException ioe) {
             throw new MIMEParsingException(ioe);
         }