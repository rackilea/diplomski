class ClassRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(
            JList<?> list, Object value, int index, boolean selected, boolean focus) {
        if (value instanceof Class) {
            value = ((Class<?>) value).getSimpleName();
        }
        return super.getListCellRendererComponent(list, value, index, selected, focus);
    }
}