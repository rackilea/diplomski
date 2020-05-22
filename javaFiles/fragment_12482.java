InputStream in = /* ... */;
try {
} catch (...) {
} finally {
    try {
        in.close();
    } catch (...) {
    } finally {
    }
}