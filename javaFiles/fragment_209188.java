@Override
public boolean shouldYieldFocus(JComponent input) {
    if (verify(input)) {
        tf.setValue(date);
        tf.setForeground(Color.black);
        return true;
    } else {
        tf.setForeground(Color.red);
        return false;
    }
}