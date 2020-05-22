public MainView() {
    Div textContainer = new Div();

    textContainer.add(createHeader("Organization Using Domain Name"));
    textContainer.add(createLine("Name", dto.getDomainInfo().getDomainName()));
    textContainer.add(createLine("Organization Name", dto.getDomainInfo().getOrganizationName()));
    textContainer.add(createLine("Street Address", dto.getDomainInfo().getStreetAddress()));

    textContainer.add(createHeader("Administrative Contact/Agent"));
    textContainer.add(createLine("Handle", dto.getDomainInfo().getHandle()));
    textContainer.add(createLine("Name", dto.getDomainInfo().getName()));

    add(textContainer);
}

private Component createLine(String key, String value) {
    int keyLength = 24;
    StringBuilder sb = new StringBuilder(key);

    // Add padding dots ...
    for(int i = key.length(); i < keyLength; i++) {
        sb.append(".");
    }
    sb.append(": ");
    sb.append(value);

    Paragraph line = new Paragraph(sb.toString());
    line.getStyle().set("font-family", "monospace");
    line.getStyle().set("margin", "0");

    return line;
}

private Component createHeader(String caption) {
    Paragraph header = new Paragraph(caption);
    header.getStyle().set("font-family", "monospace");
    header.getStyle().set("margin", "16px 0 0 0 ");
    return header;
}