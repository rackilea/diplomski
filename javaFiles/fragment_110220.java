private boolean isTabExist(String title) {
    for (int i = 0; i < tabCount; i++) {
        if (jTabbedPane1.getTitleAt(i).equalsIgnoreCase(title)) {
            jTabbedPane1.setSelectedIndex(i);
            return true;
        }
    }
    return false;
}