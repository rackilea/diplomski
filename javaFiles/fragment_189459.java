StyledDocument document = new DefaultStyledDocument():

SimpleAttributeSet attributes = new SimpleAttributeSet();

TabStop[] tabStops = new TabStop[3];
tabStops[0] = new TabStop(4.0, TabStop.ALIGN_LEFT, TabStop.LEAD_DOTS);
tabStops[1] = new TabStop(20.0, TabStop.ALIGN_LEFT, TabStop.LEAD_DOTS);
tabStops[2] = new TabStop(30.0, TabStop.ALIGN_LEFT, TabStop.LEAD_DOTS);

TabSet tabSet = new TabSet(tabStops);
StyleConstants.setTabSet(attributes, tabSet);
document.setParagraphAttributes(0, 0, attributes, false);