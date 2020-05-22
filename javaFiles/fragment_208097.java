try {
    throw new IOException("Like this");
} catch (IOException e) {
    e.printStackTrace();
    System.err.println(e);
}