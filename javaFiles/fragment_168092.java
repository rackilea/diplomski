public String getEscappedConcernedElementXML(String sourceXML) {
    String concernedElementXMLString = findConcernedElementInXML(sourceXML);
    if (concernedElementXMLString == null || (concernedElementXMLString.equal(""))) {
        return concernedElementXMLString;
    }

    concernedElementXMLString = escapeSecondAttributeValueInXML(corcernedElementXMLString);

    return concernedElementXMLString;
}


public String escapeSecondAttributeValueInXML(String sourceXML) {
    String secondAttributeStartCursor = "SecondAttribute=\"";
    int secondAttributeIndex = sourceXML.indexOf(secondAttributeStartCursor);

    String secondAttributeEndCursor = "\">";
    int secondAttributeEndIndex = sourceXML.indexOf(secondAttributeEndCursor, secondAttributeIndex);


    String secondAttributeValue = sourceXML.substring(secondAttributeIndex + secondAttributeStartCursor.length(), secondAttributeEndIndex);
    String escappedSecondAttributeValue = StringEscapeUtils.escapeXml(secondAttributeValue);

    return sourceXML.replace(secondAttributeValue, escappedSecondAttributeValue);
}