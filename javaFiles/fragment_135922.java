Message msg = in.readNext();
    SubstreamId msgSubstream = msg.getSubstreamId();
    int exe = threadById.computeIfAbsent(msgSubstream,
            id -> findBestExecutor());
    streamThreads[exe].execute(() -> {
        // processing goes here
    });