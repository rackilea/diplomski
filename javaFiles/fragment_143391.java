public void write(Writer w, Stat s) throws IOException {
   if (w == null)
       throw new IllegalArgumentException("writer is null");
   if (s == null)
       throw new IllegalArgumentException("stats is null");
   ...