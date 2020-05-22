class MyPane extends JTextPane {

    private static final long serialVersionUID = 1L;
    private boolean m_enabled = true;
    private Color defaultForegroundColor, disabledTextColor;

    public MyPane() {
        defaultForegroundColor = getForeground();
        disabledTextColor = getDisabledTextColor();
    }

    public void setEnabled(boolean enabled) {
        m_enabled = enabled;

        if (m_enabled) {
            setForeground(defaultForegroundColor);
        } else {
            setForeground(disabledTextColor);
        }
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}