private Element createTimestamp(Document doc) {
    // Use createElementNS instead of createElement, otherwise you will get the aforementioned NPE
    Element signatureProperties = doc.createElementNS("", "SignatureProperties");
    Element signatureProperty = signatureProperties.getOwnerDocument().createElementNS("","SignatureProperty");
    signatureProperty.setAttribute("Target", "#" + SIGNATURE_ID);
    signatureProperty.setAttribute("Id", "TimeStamp");
    Element timeStamp = signatureProperty.getOwnerDocument().createElementNS("", "TimeStamp");

    ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
    Element date = timeStamp.getOwnerDocument().createElementNS("", "Date");
    date.setTextContent(now.toLocalDate().toString());
    Element time = timeStamp.getOwnerDocument().createElementNS("", "Time");
    time.setTextContent(now.toLocalTime().toString() + now.getOffset().toString());

    timeStamp.appendChild(date);
    timeStamp.appendChild(time);
    signatureProperty.appendChild(timeStamp);
    signatureProperties.appendChild(signatureProperty);
    return signatureProperties;
}