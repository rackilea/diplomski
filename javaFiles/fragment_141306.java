String nexmoApiKey = "";
String nexmoApiSecret = "";
String sessionId = "";
String token = "";
SipProperties properties = new SipProperties.Builder()
     .sipUri("sip:15555555555@sip.nexmo.com")
     .from("from@example.com")
     .headersJsonStartingWithXDash(headerJson)
     .userName(nexmoApiKey)
     .password(nexmoApiSecret)
     .secure(false)
     .build();
 Sip sip = opentok.dial(sessionId, token, properties);