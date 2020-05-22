if (Desktop.isDesktopSupported()) {
    Desktop desktop = Desktop.getDesktop();
    if (desktop.isSupported(Desktop.Action.OPEN)) {
         desktop.open(file);
    }
}