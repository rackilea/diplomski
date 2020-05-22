public static final String ACCOUNT_SID = "ACCOUNT_SID";
    public static final String AUTH_TOKEN = "AUTH_TOKEN";
    public static final String TWILIO_NUMBER = "Assigned Twilio Number";

    public static void sendSms() {
        try {
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

            // Build a filter for the MessageList
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("Body", "Hello, World REST Message!"));
            params.add(new BasicNameValuePair("To", "Real Verified Number")); //Add real number here
            params.add(new BasicNameValuePair("From", TWILIO_NUMBER));

            MessageFactory messageFactory = client.getAccount().getMessageFactory();
            Message message = messageFactory.create(params);
            System.out.println(message.getSid());
            System.out.println("Message :"+message.getSid());
        } catch (TwilioRestException e) {
            System.out.println(e.getErrorMessage());
        }
}