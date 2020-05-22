output.write(
    String.format(
        "GET /advice/%d HTTP/1.1\r\nHost: fucking-great-advice.ru\r\nConnection: keep-alive\r\n\r\n",
        numberAdvice
    )
);
output.flush();