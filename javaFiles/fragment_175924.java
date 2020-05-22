public static void main(String[] args) {

    int portNumber = 80;

    if(args.length > 0){
        portNumber = Integer.parseInt(args[0]);
    }

    port(portNumber);

    get("/", (req, res) -> "Hello Web");

    post("/sms", (req, res) -> {
        res.type("application/xml");
        // Remove this: System.out.println(req.body());

        String messageToSpend = req.queryParams("Body");

        if ("hello".equals(messageToSpend)){
            System.out.println("You said hello");
        }

        Body body = new Body
                .Builder(messageToSend)
                .build();
        Message sms = new Message
                .Builder()
                .body(body)
                .build();
        MessagingResponse twiml = new MessagingResponse
                .Builder()
                .message(sms)
                .build();
        return twiml.toXml();
    });
}