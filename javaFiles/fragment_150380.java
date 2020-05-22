String msg = "<iq type=\"set\" id=\"session_1\"><session xmlns=\"urn:ietf:params:xml:ns:xmpp-session\"/></iq>";

    try {
        os.write(msg.getBytes());
        os.flush();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        reader.next();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    if (reader.getName().equals("iq")) {

        while (true) {

                if((reader.getType() == XmlReader.END_TAG) && reader.getName().equals("iq"))
                {
                    session=true;
                    break;
                }


            try {
                reader.next();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    //
now the problem is solved.thank you