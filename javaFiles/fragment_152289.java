Field idField = null;
try {
    idField = myModel.getClass().getField("id");
} catch (NoSuchFieldException nsfe) {
    throw new RuntimeException(nsfe);
}