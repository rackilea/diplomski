/**
 * Splits a XML file's payload into two new files based on a regex condition. The payload is a specific XML tag in the
 * input file that is repeated a number of times. All tags before and after the payload are added to both files in order
 * to keep the same structure.
 * 
 * The content of each payload tag is compared to the regex condition and if true, it is added to the primary output file.
 * Otherwise it is added to the secondary output file. The payload can be empty and an empty payload tag will be added to
 * the secondary output file. Note that the output will not be an unaltered copy of the input as self-closing XML tags are
 * altered to corresponding opening and closing tags.
 * 
 * Data is streamed from the input file to the output files, keeping memory usage small even with large files.
 * 
 * @param inputFilename Path and filename for the input XML file
 * @param outputFilenamePrimary Path and filename for the primary output file
 * @param outputFilenameSecondary Path and filename for the secondary output file
 * @param payloadTag XML tag name of the payload
 * @param payloadParentTag XML tag name of the payload's direct parent
 * @param splitRegex The regex split condition used on the payload content
 * @throws Exception On invalid filenames, missing input, incorrect XML structure, etc.
 */
public static void splitXMLPayload(String inputFilename, String outputFilenamePrimary, String outputFilenameSecondary, String payloadTag, String payloadParentTag, String splitRegex) throws Exception {

    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
    XMLEventReader xmlEventReader = null;
    FileInputStream fileInputStream = null;
    FileWriter fileWriterPrimary = null;
    FileWriter fileWriterSecondary = null;
    XMLEventWriter xmlEventWriterSplitPrimary = null;
    XMLEventWriter xmlEventWriterSplitSecondary = null;

    try {
        fileInputStream = new FileInputStream(inputFilename);
        xmlEventReader = xmlInputFactory.createXMLEventReader(fileInputStream);

        fileWriterPrimary = new FileWriter(outputFilenamePrimary);
        fileWriterSecondary = new FileWriter(outputFilenameSecondary);
        xmlEventWriterSplitPrimary = xmlOutputFactory.createXMLEventWriter(fileWriterPrimary);
        xmlEventWriterSplitSecondary = xmlOutputFactory.createXMLEventWriter(fileWriterSecondary);

        boolean isStart = true;
        boolean isEnd = false;
        boolean lastSplitIsPrimary = true;

        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();

            // Check for start of payload element
            if (!isEnd && xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                if (startElement.getName().getLocalPart().equalsIgnoreCase(payloadTag)) {
                    if (isStart) {
                        isStart = false;
                        // Flush the event writers as we'll use the file writers for the payload
                        xmlEventWriterSplitPrimary.flush();
                        xmlEventWriterSplitSecondary.flush();
                    }

                    String order = getTagAsString(xmlEventReader, xmlEvent, payloadTag, xmlOutputFactory);
                    if (order.matches(splitRegex)) {
                        lastSplitIsPrimary = true;
                        fileWriterPrimary.write(order);
                    } else {
                        lastSplitIsPrimary = false;
                        fileWriterSecondary.write(order);
                    }
                }
            }
            // Check for end of parent tag
            else if (!isStart && !isEnd && xmlEvent.isEndElement()) {
                EndElement endElement = xmlEvent.asEndElement();
                if (endElement.getName().getLocalPart().equalsIgnoreCase(payloadParentTag)) {
                    isEnd = true;
                }
            }
            // Is neither start or end and we're handling payload (most often white space)
            else if (!isStart && !isEnd) {
                // Add to last split handled
                if (lastSplitIsPrimary) {
                    xmlEventWriterSplitPrimary.add(xmlEvent);
                    xmlEventWriterSplitPrimary.flush();
                } else {
                    xmlEventWriterSplitSecondary.add(xmlEvent);
                    xmlEventWriterSplitSecondary.flush();
                }
            }

            // Start and end is added to both files
            if (isStart || isEnd) {
                xmlEventWriterSplitPrimary.add(xmlEvent);
                xmlEventWriterSplitSecondary.add(xmlEvent);
            }
        }

    } catch (Exception e) {
        logger.error("Error in XML split", e);
        throw e;
    } finally {
        // Close the streams
        try {
            xmlEventReader.close();
        } catch (XMLStreamException e) {
            // ignore
        }
        try {
            xmlEventReader.close();
        } catch (XMLStreamException e) {
            // ignore
        }
        try {
            xmlEventWriterSplitPrimary.close();
        } catch (XMLStreamException e) {
            // ignore
        }
        try {
            xmlEventWriterSplitSecondary.close();
        } catch (XMLStreamException e) {
            // ignore
        }
        try {
            fileWriterPrimary.close();
        } catch (IOException e) {
            // ignore
        }
        try {
            fileWriterSecondary.close();
        } catch (IOException e) {
            // ignore
        }
    }
}

/**
 * Loops through the events in the {@code XMLEventReader} until the specific XML end tag is found and returns everything
 * contained within the XML tag as a String.
 * 
 * Data is streamed from the {@code XMLEventReader}, however the String can be large depending of the number of children
 * in the XML tag.
 * 
 * @param xmlEventReader The already active reader. The starting tag event is assumed to have already been read
 * @param startEvent The starting XML tag event already read from the {@code XMLEventReader}
 * @param tag The XML tag name used to find the starting XML tag
 * @param xmlOutputFactory Convenience include to avoid creating another factory
 * @return String containing everything between the starting and ending XML tag, the tags themselves included
 * @throws Exception On incorrect XML structure
 */
private static String getTagAsString(XMLEventReader xmlEventReader, XMLEvent startEvent, String tag, XMLOutputFactory xmlOutputFactory) throws Exception {
    StringWriter stringWriter = new StringWriter();
    XMLEventWriter xmlEventWriter = xmlOutputFactory.createXMLEventWriter(stringWriter);

    // Add the start tag
    xmlEventWriter.add(startEvent);

    // Add until end tag
    while (xmlEventReader.hasNext()) {
        XMLEvent xmlEvent = xmlEventReader.nextEvent();

        // End tag found
        if (xmlEvent.isEndElement() && xmlEvent.asEndElement().getName().getLocalPart().equalsIgnoreCase(tag)) {
            xmlEventWriter.add(xmlEvent);
            xmlEventWriter.close();
            stringWriter.close();

            return stringWriter.toString();
        } else {
            xmlEventWriter.add(xmlEvent);
        }
    }

    xmlEventWriter.close();
    stringWriter.close();
    throw new Exception("Invalid XML, no closing tag for <" + tag + "> found!");
}