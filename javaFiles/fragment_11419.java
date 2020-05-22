table.getTableHeader().setUI(new BasicTableHeaderUI(){
    public void installUI(JComponent c) {
        try {
            final Field f = getClass().getSuperclass().getDeclaredField("resizeCursor");
            f.setAccessible(true);
            f.set(null, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } catch (ReflectiveOperationException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        super.installUI(c);
    }
});