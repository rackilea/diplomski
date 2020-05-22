Text textControl = ....


KeyStroke keyStroke = KeyStroke.getInstance("Ctrl+Space");

new ContentProposalAdapter(textControl, new TextContentAdapter(), provider, keyStroke, null);