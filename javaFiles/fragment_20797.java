int which = 0;
for (int i = 0; i < serveButtons.size(); i++) {
  if (serveButtons.get(i).isArmed()) {
    which = i;
    break;
  }
}
orderContentsList.get(which).setText(null);