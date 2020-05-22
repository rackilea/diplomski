for (int height = 100; height < 150; height += 5) {
    Div div = new Div();
    div.setProperty(Property.OVERFLOW_Y, OverflowPropertyValue.HIDDEN);
    div.add(new Paragraph(height + " Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."));
    div.setHeight(height);
    div.setNextRenderer(new OverflowHiddenDivRenderer(div));
    document.add(div);
}