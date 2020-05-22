Stream.continually(() -> {       
    try {
        return br.readLine();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}).takeWhile((line) -> line != null)