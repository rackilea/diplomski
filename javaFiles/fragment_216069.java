String rawString="Give me A on my homework!";
    char[] key="OH no!".toCharArray();
    StringBuilder thisIsEncrypted=new StringBuilder();

    for (int i = 0; i < rawString.length(); i++) {
        thisIsEncrypted.append((char) (rawString.charAt(i) ^ key[i % key.length]));
    }

    // Now we have encrypted it - lets decrypt

    rawString=thisIsEncrypted.toString();
    thisIsEncrypted=new StringBuilder();
    for (int i = 0; i < rawString.length(); i++) {
        thisIsEncrypted.append((char) (rawString.charAt(i) ^ key[i % key.length]));
    }
    System.out.println("This was encrypted and then decrypted: "+thisIsEncrypted);