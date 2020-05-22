String prevTab, curTab;

public void showTab(String newTab) {
  prevTab = curTab;
  curTab = newTab;
  layout.show(parent, curTab);
}

public void goBack() {
  layout.show(parent, prevTab);
}