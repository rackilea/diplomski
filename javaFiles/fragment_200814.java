@Override
protected void done() {
    String result;
    try {
        result = get();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    // Now do whatever you want with the loaded data:
    ...
}