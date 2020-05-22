public void runCommand() {
    try {
        new ProcessBuilder("gsutil", "-m", "cp", "-r",
            "gs://my_bucket/705/201609040613/output/html_pages",
            "file:/Users/eladb/WorkspaceQa/GsClient/build/resources/main/downloads/")
        .inheritIO()
        .start()
        .waitFor();
    } catch(IOException | InterruptedException e) {
        e.printStackTrace();
    }
}