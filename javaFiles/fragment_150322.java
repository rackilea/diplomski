public void historyAction() {
    String html = new String();
    for (String link : history) {
        html = html + "<a href=\"" + link + "\">" + link + "</a>\n";
    }
    html = "<html><body" + html + "</body></html>";
    JEditorPane ep = new JEditorPane("text/html", html);
    ep.addHyperlinkListener(new HyperlinkListener() {
        public void hyperlinkUpdate(HyperlinkEvent e) {
            if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {
                loadURL(e.getURL().toString());
            }
        }
    });
    ep.setEditable(false);
    JOptionPane.showMessageDialog(null, ep);
}