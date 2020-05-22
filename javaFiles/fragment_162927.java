private Set<String> activeDownloads = new HashSet<>();

@Async
public void processDownloadRequest(DownloadRequest downloadRequest) {
    synchronized(this.activeDownloads) {
        if (this.activeDownloads.contains(downloadRequest.getId()) {
            // Duplicate download attempt - log it?
            return;
        } else {
            this.activeDownloads.put(downloadRequest.getId());
        }
    }


    try {
        accountProfileProcessor.run(downloadRequest);
    } finally {
        synchronized(this.activeDownloads) {
            this.activeDownloads.remove(downloadRequest.getId());
        }
    }
}