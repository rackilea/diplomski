Desktop desktop;
if (Desktop.isDesktopSupported() 
    && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
  URI mailto = new URI("mailto:john@example.com?subject=Hello%20World");
  desktop.mail(mailto);
} else {
  // TODO fallback to some Runtime.exec(..) voodoo?
  throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)");
}