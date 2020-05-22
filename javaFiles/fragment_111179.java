@Override
protected void finalize() throws Throwable {
    try {
        this.close();
    } finally {
        super.finalize();
    }
}