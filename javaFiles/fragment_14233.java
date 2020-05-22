JEditorPane jep = new JEditorPane();
jep.addHyperlinkListener(new HyperlinkListener() {

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        HyperlinkEvent.EventType type = e.getEventType();
        final URL url = e.getURL();
        if (type == HyperlinkEvent.EventType.ENTERED) {
            // do desired highlighting
        } else if (type == HyperlinkEvent.EventType.ACTIVATED) {
            // open browser
        }
    }
});