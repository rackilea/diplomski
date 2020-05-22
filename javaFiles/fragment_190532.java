String encryptedText = "/O0sJjPUFgRGfND1TpHrkbyCalgY/rSpE8nhJ/wYjYY=";
String encryptedTextAndEncoded = new String(java.util.Base64.getEncoder().encode(encryptedText.getBytes()));

try {
        // Using standard Base64 in URL requires encoding of '+', '/' and '=' 
        encryptedTextAndEncoded = URLEncoder.encode(encryptedTextAndEncoded, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

String.format("%s%s", "youtube.com/videos/", encryptedTextAndEncoded);