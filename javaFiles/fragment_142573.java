BufferedWriter bw = null;
try {
    bw = new BufferedWriter(...);
    bw.write(...);
} finally {
    if (bw != null) try { bw.close(); } catch (IOException logOrIgnore) {}
}