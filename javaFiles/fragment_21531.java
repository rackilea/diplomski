public Mono<Void> cleanUpUploadedFiles() {
    return getResource("/files", FilesOverview.class) // Retrieve the file list
            .flatMapIterable(FilesOverview::getFiles) // Create a Flux from the file list
            .map(FileOverview::getName) // Map the file overview to the file name
            .flatMap(this::deleteFile) // Delete the file
            .then(); // Just return a Mono<Void>
}

private Mono<Void> deleteFile(String fileName) {
    return getWebClient()
            .delete()
            .uri("/files/local/{fileName}", fileName)
            .exchange() // Perform the delete operation
            .onErrorMap(e -> new MyException(String.format("could not execute rest call to delete uploaded files with uuid %s", fileName))) // Handle errors
            .map(ClientResponse::statusCode) // Map the response to the status code
            .flatMap(statusCode -> {
                // If the operation was not successful signal an error
                if (statusCode.isError()) {
                    return Mono.error(new MyException(String.format("cannot delete uploaded files with uuid %s", fileName)));
                }

                // Otherwise return a Mono<Void>
                return Mono.empty();
            });
}