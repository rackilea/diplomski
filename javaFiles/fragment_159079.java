public class CursorClosable implements AutoClosable {
    private Cursor cursor;

    public CursorClosable(Cursor cursor) {
        this.cursor = cursor;
    }

    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public void close() throws Exception {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }
}