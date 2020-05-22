byte[] encryptedMsg = Base64.encodeBase64(encryptString(message, temp.loadCASPublicKey()));


        System.out.println("ENCRYPTED MESSAGE byte Length: "+encryptedMsg.length);


        //Convert to String in order to send
        String stringMessage = new String(encryptedMsg, "UTF-8");
        System.out.println("ENCRYPTED MESSAGE String Length: "+stringMessage.length());

        //Convert String back to Byte[] and decrpt
        byte[] byteMessage = Base64.decodeBase64(stringMessage.getBytes("UTF-8"));
        System.out.println("ENCRYPTED MESSAGE byte Length: "+byteMessage.length);