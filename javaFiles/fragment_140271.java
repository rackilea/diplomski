JComponent panel = new JPanel();
final int maxSize = 3;
for (int i = 0; i < 4; i++) {
    final JTextField field = new JTextField(5);
    NavigationFilter filter = new NavigationFilter() {

        @Override
        public void setDot(FilterBypass fb, int dot, Bias bias) {
            if (dot >= maxSize) {
                fb.setDot(0, bias);
                field.transferFocus();
                return;
            }
            fb.setDot(dot, bias);
        }

        @Override
        public void moveDot(FilterBypass fb, int dot, Bias bias) {
            if (dot >= maxSize) { 
                fb.setDot(0, bias);
                field.transferFocus();
                return;
            }
            fb.moveDot(dot, bias);
        }

    };
    field.setNavigationFilter(filter);
    ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentSizeFilter(maxSize));
    panel.add(field);
}