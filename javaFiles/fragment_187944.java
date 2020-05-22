if (resourceElement != null) {

        titleElement = (Element)resourceElement.getElementsByTagName("title").item(0);  

        resource.setTitle( titleElement == null ? "unknown" : titleElement.getTextContent() );

        descriptionElement = (Element)resourceElement.getElementsByTagName("description").item(0);

        resource.setDescription( descriptionElement == null ? "unknown" : descriptionElement.getTextContent() );

        identifierElement = (Element)resourceElement.getElementsByTagName("identifier").item(0);


        if (identifierElement != null) {

            Identifier identifier = new Identifier();

            urlElement = (Element)identifierElement.getElementsByTagName("url").item(0);

            identifier.setURL( urlElement == null ? "unknown" : urlElement.getTextContent() );

            // ADDED THIS LINE HERE
            resource.setIdentifier(identifier);

            subjectElement = (Element)resourceElement.getElementsByTagName("subjects").item(0);

            if (subjectElement != null) {

                subjectList =     subjectElement.getElementsByTagName("subject");

            ....