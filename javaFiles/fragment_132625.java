/**
 * Returns first child element with matching element name or else
 * throws an exception.  Will never return null.
 */
Element getMandatoryChildElement(Element parent, String elementName)
throws MissingElementException;