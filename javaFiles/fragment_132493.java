// You can turn your bytes into a string using encoder.
    String keyAsString = Base64.getEncoder().encodeToString(key);
    // ....
    ///

    // When you need your bytes back you call the decoder on the string.
    byte[] keyBytes = Base64.getDecoder().decode(keyAsString);