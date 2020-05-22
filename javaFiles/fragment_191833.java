@Value("${server.port}")
private String          serverPort;

@Value("${server.context-path}")
private String          serverContextPath;

public void openAppInBrowser() {
    final Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        logger.debug("Open Browser.");
        try {
            desktop.browse(new URI("http://localhost" +
                    (StringUtils.isNotEmpty(serverPort) ? ":" + serverPort : "") +
                    (StringUtils.isNotEmpty(serverContextPath) ? serverContextPath : "")));
        } catch (final Exception e) {
            logger.debug("Error opening Browser", e);
        }
    }
}