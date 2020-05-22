SimpleAttributeSet rightAlign = new SimpleAttributeSet();
    SimpleAttributeSet leftAlign = new SimpleAttributeSet();

    StyleConstants.setAlignment(rightAlign, StyleConstants.ALIGN_RIGHT);
    StyleConstants.setForeground(rightAlign, Color.lightGray);
    StyleConstants.setFontSize(rightAlign, 11);

    StyleConstants.setAlignment(leftAlign, StyleConstants.ALIGN_LEFT);
    StyleConstants.setForeground(leftAlign, Color.black);
    StyleConstants.setFontSize(leftAlign, 13);

    String left = "name";
    String right = "timeHis\n";

    sdoc.insertString(0, left, leftAlign);
    sdoc.insertString(left.length(), right, rightAlign);

    sdoc.setParagraphAttributes(0, left.length(), leftAlign, false);               
    sdoc.setParagraphAttributes(left.length()+1, sdoc.getLength()-1-left.length(), rightAlign, false);