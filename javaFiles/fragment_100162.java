@Override
public Component getListCellRendererComponent(
    JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    if (value != null) {
        User user = (User) value;
        String pres = user.getPresence().toLowerCase();
        img.setIcon(default_img);
        if (pres.contains("unavailable"))
            icn.setIcon(off_img);
        else
            icn.setIcon(on_img);
        name.setText(user.getName());
        if (isSelected) {
            setBackground(Color.lightGray);
            panel.setBackground(Color.lightGray);
        } else {
            setBackground(Color.white);
            panel.setBackground(Color.white);
        }
    }
    return this;
}