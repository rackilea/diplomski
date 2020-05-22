StreamingResponseBody responseBody = outputStream -> {
    Files.copy(file.toPath(), outputStream);
};

response.ok()
    .contentLength(file.length())
    .body(responseBody);
return response;