public class oAuthGenerator {
private String httpMethod;
    private String params;
    private String url;
    //Required for percent encoding
    private static final String ENC = "ASCII";
    //Required for nonce
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
    //As provided by Payrun.io
    private static final String secretKey = "aSecretKey";
    //As provided by Payrun.io
    private static final String consumerKey ="aConsumerKey";
    private List veriList;

    //Constructor for setting signature base string values.
    //@Param url needs to be percent encoded
    //@Param params needs to be percent encoded, this is done @Method generateOAuth()
    public oAuthGenerator(String httpMethod,String url )throws Exception {
        veriList= new ArrayList<String>();
        veriList.add("POST");
        veriList.add("GET");
        veriList.add("PUT");
        veriList.add("DELETE");

        if (veriList.contains(httpMethod)){
        this.httpMethod = httpMethod+"&";}
            this.url = URLEncoder.encode(url,ENC)+"&";
    }

    //A method used to generate the OAuth Authorization header
    //@Method randomAlphaNumeric() calls internal method using instance variable ALPHA_NUMERIC_STRING
    //@Method getSignature() returns String HMACSHA1 > Base64 encoded value of httpMethod,url,params
    public String generateOAuth()throws Exception{
        //Set timestamp as seconds from 01-01-1970
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()/1000);
        Long aTimestamp = timestamp.getTime();
        //Set nonce which is a 10 digit random, non repeating alpha-numeric value
        String aNonce = randomAlphaNumeric(10);
        //Normalize and form param string
        String normalizedParams = "oauth_consumer_key="+consumerKey+"&"+"oauth_nonce="+aNonce+"&"+"oauth_signature_method="+"HMAC-SHA1"+"&"+"oauth_timestamp="+ aTimestamp.toString()+"&"+"oauth_version="+"1.0";
        //Percent encoded params
        params = URLEncoder.encode(normalizedParams,ENC);
        //Set signature variable
        String signature = getSignature();
        //place into required format
        String oAuthResult = "OAuth "+"oauth_version="+"\"1.0\""+","+"oauth_consumer_key="+"\"" + consumerKey + "\""+","+"oauth_signature_method="+"\"HMAC-SHA1\""+","+"oauth_timestamp="+"\""+aTimestamp+"\""+","+"oauth_nonce="+"\""+aNonce+"\""+","+"oauth_signature="+"\""+signature+"\"";
        return oAuthResult;
    }
    // A method designed to return a hashed and base64 encoded value.
    //@Param aString holds HMAC-SHA1 and Base 64 encoded value of variables httpMethod,url,params
    //@Param result holds percent encoded value of aString
    private String getSignature()
            throws Exception {
        //form base string
        StringBuilder base = new StringBuilder();
        base.append(httpMethod);
        base.append(url);
        base.append(params);
        //Set SecretKey of variable secretKey using HMAC-SHA1 algorithm
        SecretKey signingKey = new SecretKeySpec(secretKey.getBytes(), "HmacSHA1");
        // Get an hmac_sha1 Mac instance and initialize with the signing key
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signingKey);
        // Compute the hmac on input data bytes, then encode to Base64
        String aString = Base64.getEncoder().encodeToString(mac.doFinal(base.toString().getBytes(ENC))).trim();
        //Percent encoded the Base64 value
        String result = URLEncoder.encode(aString, ENC);
        return new String(result);

    }

    //Required for nonce, returns a random alpha numeric value by using variable ALPHA_NUMERIC_STRING
    private static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}