public class TwilioUtilsExample {

    public static void main(String[] args) {

        // Account details
        String accountSid = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        String authToken = "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY";

        //This is the signature we expect
        String expected_sig = "SSSSSSSSSSSSSSSSSSSSSSSSSSSS";

        //This is the url that twilio requested
        String url = "http://UUUUUUUUUUUUUUU";

        //These are the post params twilio sent in its request
        Map<String,String> params = new HashMap<String,String>();

        // Be sure to see the signing notes at twilio.com/docs/security
        TwilioUtils util = new TwilioUtils(authToken, accountSid);

        boolean result = util.validateRequest(expected_sig, url, params);

        if (result) {
            System.out.print( "The signature is valid!\n" );
        } else {
            System.out.print( "The signature was NOT VALID.  It might have been spoofed!\n" );
        }

    }

}