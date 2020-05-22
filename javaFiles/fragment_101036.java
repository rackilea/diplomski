public String getVersionFromNexus(NexusResource version, String oysterName, String customer) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Path unzipDirectory = util.getTempFolder("unzipped");
        TomcatNexusLayout.downloadZip(version, util.getTempFolder(version.getText()), c -> {
            List<Path> customerFiles = TomcatNexusLayout.restUnzip(c, unzipDirectory);
            Files.delete(c);
            deployOysterVersion(oysterName, (ArrayList<Path>) customerFiles, customer);
            completableFuture.complete(startOyster(oysterName));
        });
        try {
            return completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return "FAILED";
    }