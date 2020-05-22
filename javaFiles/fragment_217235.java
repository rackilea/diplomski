private boolean isChecking;
@Override
public void setSelected(final ButtonModel m, boolean b) {   
    if (isChecking) return;
    isChecking = false;
    if (!b) {
        return;
    }
    if (m == buttonB.getModel()) {
        isChecking = true;
        final boolean select = check();
        if (select) {
            superSetSelected(m, select);
        }
        isChecking = false;
        return;
    } else {
        superSetSelected(m, b);
    }
}

protected void superSetSelected(ButtonModel m, boolean b) {
    super.setSelected(m, b);
}