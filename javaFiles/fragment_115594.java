try{
           // say you are comparing FileReader objects that
           // refer to XML documents
           assertXMLEqual(filereader1, filereader2); 
        } catch (final SAXException e) {
           // show faiulre message
        } catch (final IOException e) {
           // show failure message
        } catch (final AssertionError e) {
            System.err.println(e.toString());
        }