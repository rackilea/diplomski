private int panelContains(JPanel panel) {
    JLabel Value;
    for (Entry<Integer, JLabel> entry : Blackbox.entrySet()) {
        Value = entry.getValue();
        if (Value.getParent() == panel) {
             return 1;
        }
    }
    return 0;
}