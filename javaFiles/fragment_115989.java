public String setPayload(MuleMessage message, String outputEncoding) {

    message.setPayload(outputEncoding);
    //String payload1 = "#[ReadFile]";
    return null;

}