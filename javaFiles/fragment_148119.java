public boolean verifyAuth(JsonObject Telegram_User){

    String hash = Telegram_User.remove("hash").getAsString();

    try {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        String[] t = Telegram_User.toString().replace("{","").replace("}","").replace("\":","=").replace(",","\n").replace("\"","").split("\n");
        sha256_HMAC.init(new SecretKeySpec(MessageDigest.getInstance("SHA-256").digest(BezouroBot.telegram.getBotToken().getBytes(StandardCharsets.UTF_8)),"SHA256"));

        Arrays.sort(t);
        StringBuilder i = new StringBuilder();
        boolean First = true;

        for (String s : t) if(First){ First = false; i = new StringBuilder(s);} else i.append("\n").append(s);

        return Hex.encodeHexString(sha256_HMAC.doFinal(i.toString().getBytes())).equals(hash);

    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
        e.printStackTrace();
        return false;
    }

}