NodeList content = element.getChildNodes();
    StringBuilder textContent = new StringBuilder();
    int cntLength = content.getLength();
    for ( int i = 0; i < cntLength; i++ ) {
        Node paramValue = content.item( i );
        short type = paramValue.getNodeType();
        if ( ( type == Node.TEXT_NODE ) || ( type == Node.CDATA_SECTION_NODE ) ) {
            textContent.append( ((CharacterData) paramValue).getData() );   //  Both Text and CDATASection nodes are SubType of CharacterData
        }
    }