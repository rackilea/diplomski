public static void main(String[] args) {
    Browser browser = new Browser();
    BrowserView view = new BrowserView(browser);

    JFrame frame = new JFrame("Google Maps");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.add(view, BorderLayout.CENTER);

    // Let's add a button
    frame.add(new JButton("My Button"), BorderLayout.SOUTH);

    frame.setSize(1500,1000);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    browser.loadURL("http://maps.google.com");
}