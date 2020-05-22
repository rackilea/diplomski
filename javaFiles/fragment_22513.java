@Override
public void close() throws IOException {
    Throwable t = null;
    try {
        r1.close();
    } catch (Throwable t1) {
        t = t1;
        throw t1;
    } finally {
        if (t != null) {
            try {
                r2.close();
            } catch (Throwable t2) {
                t.addSuppressed(t2);
            }
        } else {

            r2.close();
        }
    }
}