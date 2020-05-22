// your standard icon
Icon icon = ...
BasicTreeUI ui = (BasicTreeUI) tree.getUI();
int iconWidth = icon.getIconWidth() / 2;
ui.setLeftChildIndent(iconWidth); 
ui.setRightChildIndent(iconWidth + 10);