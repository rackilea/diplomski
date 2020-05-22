public static void main(String[] args) {
    if (!Desktop.isDesktopSupported()) {
        System.err.println("Desktop is not supported. Exiting");
        System.exit(1);
    }
    String message = "Welcome Please Enter URL to Begin!";
    String title = "Enter URL";
    int messageType = JOptionPane.PLAIN_MESSAGE;
    String url = JOptionPane.showInputDialog(null, message, title, messageType);
    if (url == null) {
        System.err.println("Cancelled by user");
        System.exit(0);
    } else if (url.trim().isEmpty()) {
        System.err.println("You must enter a URL. Exiting");
        System.exit(2);
    }


    URI uri = null;
    try {
        uri = new URI(url);
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(uri);
    } catch (URISyntaxException | IOException e) {
        String text = "Invalid URL \"" + url + "\". Exiting";
        System.err.println(text);
        e.printStackTrace();            
    }
}