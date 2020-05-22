try
     {
        StringWriter output = new StringWriter ();
        JAXBContext jc = JAXBContext.newInstance (packageId);
        FileWriter savedAs;

        // Marshal the XML data to a string buffer here
        Marshaller marshalList = jc.createMarshaller ();
        marshalList.setProperty (Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshalList.marshal (toUpdate, output);

        // append the xml to the file to update here.
        savedAs = new FileWriter (new File (xmlFileName), true);
        savedAs.write (output.toString);
        savedAs.close();
     }
     catch (IOException iox)
     {
        String msg = "IO error on save: " + iox.getMessage ();
        throw new LocalException (msg, 40012, "UNKNOWN", iox);
     }
     catch (JAXBException jbx)
     {
        String msg = "Error writing definitions: " + jbx.getMessage ();
        throw new LocalException (msg, 40005, "UNKNOWN", jbx);
     }
  }