private void processValue() throws LoadException {
    ...
    if (fx_id != null) {
        namespace.put(fx_id, value);
        injectFields(fx_id, value);
    }
    ...
}