byte[] test = printData.getBytes();
        Future<FileLock> featureLock = asynchFileChannel.lock();
        log.info("Waiting for the file to be locked ...");
        FileLock lock = featureLock.get();
        if (lock.isValid()) {
            log.debug(printData);
            Future<Integer> featureWrite = asynchFileChannel.write(
                    ByteBuffer.wrap(test), asynchFileChannel.size());
            log.info("Waiting for the bytes to be written ...");
            int written = featureWrite.get();
            log.info("I’ve written " + written + " bytes into "
                    + file.getFileName() + " locked file!");
            lock.release();
        }