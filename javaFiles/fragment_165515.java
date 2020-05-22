public static void main(String[] args) throws UnsupportedEncodingException {
    String accountName = "globalweb";
    String signedPermissions = "rl"; //read and list
    String signedService = "b";  //blob
    String signedResType = "sco";  //service, container, objects
    String start = "2018-02-22T17:16:25Z";
    String expiry = "2018-02-28T01:16:25Z";
    String signedIp = "";
    String protocol = "https";
    String signedVersion = "2017-07-29";

    String stringToSign = 
            accountName + "\n" +  
        signedPermissions + "\n" +  
        signedService + "\n" +  
        signedResType + "\n" +  
        start + "\n" +  
        expiry + "\n" +  
        signedIp + "\n" +  
        protocol + "\n" +  
        signedVersion + "\n";

    //outputs SAS Token
    System.out.println(
            "?sv="+signedVersion +
            "&ss="+signedService +
            "&srt="+signedResType + 
            "&sp="+signedPermissions +
            "&st="+start+
            "&se="+expiry+
            "&spr="+protocol+
            "&sig="+
            URLEncoder.encode(SasBuilder.generateSasSignature(MY_KEY_BASE64, stringToSign), "UTF-8"));
}