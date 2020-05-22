public void close() throws IOException {
        if (this.packageAccess == PackageAccess.READ) {
            logger.log(POILogger.WARN, 
                    "The close() method is intended to SAVE a package. This package is open in READ ONLY mode, use the revert() method instead !");
            revert();
            return;
        }
        if (this.contentTypeManager == null) {
            logger.log(POILogger.WARN,
                    "Unable to call close() on a package that hasn't been fully opened yet");
            return;
        }

        // Save the content
        ReentrantReadWriteLock l = new ReentrantReadWriteLock();
        try {
            l.writeLock().lock();
            if (this.originalPackagePath != null
                    && !"".equals(this.originalPackagePath.trim())) {
                File targetFile = new File(this.originalPackagePath);
                if (!targetFile.exists()
                        || !(this.originalPackagePath
                                .equalsIgnoreCase(targetFile.getAbsolutePath()))) {
                    // Case of a package created from scratch
                    save(targetFile);
                } else {
                    closeImpl();
                }
            } else if (this.output != null) {
                save(this.output);
                output.close();
            }
        } finally {
            l.writeLock().unlock();
        }

        // Clear
        this.contentTypeManager.clearAll();
    }