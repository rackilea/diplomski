Boolean messageWaiting = true;
while (messageWaiting) {
    messageWaiting =
         jmsTemplate.browse(myQueue,
                           (session, browser) -> browser.getEnumeration().hasMoreElements());
}