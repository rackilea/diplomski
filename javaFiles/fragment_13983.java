InputStream is =
Lock lockForIs = 
lockForIs.lock();
try {
    // read is
} finally {
    lockForIs.unlock();
}