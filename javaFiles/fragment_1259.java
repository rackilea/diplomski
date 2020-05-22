CompletableFuture.supplyAsync(() -> {
        try {
            return MetadataLoginUtil.login();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    })