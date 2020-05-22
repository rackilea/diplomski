// Create and add the style
    final Style redStyle = sc.addStyle("RED", null);
    redStyle.addAttribute(StyleConstants.Foreground, Color.red);
    redStyle.addAttribute(StyleConstants.FontSize, new Integer(16));

    final Style blueStyle = sc.addStyle("BLUE", null);
    blueStyle.addAttribute(StyleConstants.Foreground, Color.blue);
    blueStyle.addAttribute(StyleConstants.FontSize, new Integer(14));
    blueStyle.addAttribute(StyleConstants.Bold, new Boolean(true));

    try {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                try {
                    String[] text = { "1a", "0b", "0c", "0d", "1e", "1f", "1g", "0h", "1i" };
                    for (int i = 0; i < text.length; i++) {
                        String s = text[i];

                        // Finally, apply the style to the heading
                        int start = pane.getText().length();
                        Style style = null;
                        if (i % 2 == 0) {
                            style = redStyle;
                        } else {
                            style = blueStyle;
                        }
                        // Add the text to the document
                        doc.insertString(start, s + " ", style);
                    }
                } catch (BadLocationException e) {
                }
            }
        });
    } catch (Exception e) {
        System.out.println("Exception when constructing document: " + e);
        System.exit(1);
    }