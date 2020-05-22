int position = 160;
for (String label : names) {
    GLabel showName = new GLabel(label, (getWidth() / 2.0) - 100, (getHeight() / 2.0) - position);
    showName.move(-showName.getWidth() / 2, -showName.getHeight());
    showName.setColor(Color.WHITE);
    add(showName);
    position -= 40;
}