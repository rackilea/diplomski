try (Reader response =
    new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8)) {

    int c;
    while ((c = response.read()) >= 0) {
        System.out.print((char) c);
    }
}