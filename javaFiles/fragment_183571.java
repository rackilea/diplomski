// the field dependency
    private Writer writer; 

    ....

     switch( streamReader.next() )
        {
            case XMLStreamConstants.START_ELEMENT:
                writer.writeStartElement();
                break;
            case XMLStreamConstants.END_ELEMENT:
                writer.writeEndElements();
                break;
            case XMLStreamConstants.CHARACTERS:
                writer.writeCharacters();
                break;
            default:
                break;
        }