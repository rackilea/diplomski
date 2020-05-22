boolean current3AutoNode = false;

        while (streamReader.hasNext()) {
            int event = streamReader.next();

            if (event == XMLStreamConstants.START_ELEMENT) {
                    if (streamReader.getLocalName().equals("_3-auto")) {
                        current3AutoNode = true;
                    }
                    else {
                        current3AutoNode = false;
                    }
            }
            else if (event == XMLStreamConstants.END_ELEMENT) {
                if (streamReader.getLocalName().equals("prefix")) {
                    current3AutoNode = true;    // after end of </prefix> we are back in <_3-auto> node
                }
                else {
                    current3AutoNode = false;
                }
            }
            if (event == XMLStreamConstants.CHARACTERS && current3AutoNode) {
                // these are the characters inside <_3-auto> </_3-auto>
                String characters = streamReader.getText();
                System.out.println(characters);
            }
        }