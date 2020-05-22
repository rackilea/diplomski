public void createOrUpdateVcard(String username, String vcard)
        throws MalformedXmlException, UserNotFoundException, SetVcardException {
    SAXReader reader = new SAXReader();
    reader.setValidation(false);
    InputStream is = new ByteArrayInputStream(vcard.getBytes());

    try {
        // Reading malformed XML will lead to DocumentException
        Document document = reader.read(is);
        Element vCardElement = document.getRootElement();
        //Checking that the user exists
        User user = userManager.getUser(username);
        //This might be redundant
        String userUsername = user.getUsername();
        log.debug("Setting VCard for " + userUsername);
        //Storing vCard into the database
        VCardManager.getInstance().setVCard(userUsername, vCardElement);        


        Presence presence = new Presence();
        JID userJID = server.createJID(username, null);
        presence.setFrom(userJID);
        presence.setStatus("");
        presence.setPriority(30);

        Element xElement = presence.addChildElement("x", "vcard-temp:x:update");
        Element photoElement = xElement.addElement("photo");

        SecureRandom random = new SecureRandom();
                    //We do not care about the actual hash - just push updates every time
        String fakeHash = new BigInteger(130, random).toString(32);
        photoElement.setText(fakeHash);

        Element cElement = presence.addChildElement("c", "http://jabber.org/protocol/caps");
        cElement.addAttribute( "ext", "voice-v1 video-v1 camera-v1" )
        .addAttribute("hash", "sha-1");

        System.out.println("SENDING PRESENCE UPDATE:\n" + presence.toXML());
        broadcastUpdate(presence);

    } catch (DocumentException e) {
        throw new MalformedXmlException(e);
    }catch (UserNotFoundException e){
        throw new UserNotFoundException();
    } catch (Exception e){
        //Unfortunately setVCard method above just throws Exception.
        //This catch block is for wrapping it up
        throw new SetVcardException();
    }
}