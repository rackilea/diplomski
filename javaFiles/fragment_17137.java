void implClose() throws IOException {
  if (ch != null)
    ch.close();
  else
    in.close();
}