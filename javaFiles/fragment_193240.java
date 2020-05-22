try(Socket socket = new Socket(ADDRESS, PORT);
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(socket.getInputStream()))) {

    socket.getOutputStream().write(QUERY);
    Stream.generate(() -> {
        try { return reader.readLine(); }
        catch (IOException ex) { throw new UncheckedIOException(ex); }
    }).parallel().forEach(System.out::println);
} catch(IOException|UncheckedIOException e) {
    e.printStackTrace();
}