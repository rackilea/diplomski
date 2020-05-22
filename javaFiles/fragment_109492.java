public static void GetFileSAS(){

    String accountName = "accountName";
    String key = "accountKey";
    String resourceUrl = "https://"+accountName+".file.core.windows.net/fileShare/fileName";

    String start = "startTime";
    String expiry = "expiry";
    String azureApiVersion = "2017-11-09";

    String stringToSign = accountName + "\n" +
                "r\n" +
                "f\n" +
                "o\n" +
                start + "\n" +
                expiry + "\n" +
                "\n" +
                "https\n" +
                azureApiVersion+"\n";

    String signature = getHMAC256(key, stringToSign);

    try{

        String sasToken = "sv=" + azureApiVersion +
            "&ss=f" +
            "&srt=o" +
            "&sp=r" +
            "&se=" +URLEncoder.encode(expiry, "UTF-8") +
            "&st=" + URLEncoder.encode(start, "UTF-8") +
            "&spr=https" +
            "&sig=" + URLEncoder.encode(signature, "UTF-8");

    System.out.println(resourceUrl+"?"+sasToken);

    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
}

private static String getHMAC256(String accountKey, String signStr) {
    String signature = null;
    try {
        SecretKeySpec secretKey = new SecretKeySpec(Base64.getDecoder().decode(accountKey), "HmacSHA256");
        Mac sha256HMAC = Mac.getInstance("HmacSHA256");
        sha256HMAC.init(secretKey);
        signature = Base64.getEncoder().encodeToString(sha256HMAC.doFinal(signStr.getBytes("UTF-8")));
    } catch (Exception e) {
        e.printStackTrace();
    }
    return signature;
}