try {
    success = gateway.send(adaptor);
}
catch (MessagingException exc) {
    System.out.println("Exception occurred : " + exc.getMessage());
}
catch (ConnectException e) {
    ...
}