ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
try {
    @SuppressWarnings("unchecked")
    ArrayList<Object> list = (ArrayList<Object>) ois.readObject();
    ...
} finally {
    ois.close();
}