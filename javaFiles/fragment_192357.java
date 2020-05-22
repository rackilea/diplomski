Map<String, Object> params = new HashMap<String, Object>(5);
params.put("callId", "myCallId");
params.put("timeStamp", "thetimeStamp");
params.put("doc", "theDoc");
params.put("docName", "theDocName");
params.put("docContent", "theDocContent");
String xmlRequest = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "requestTemplate.vm", "UTF-8", params).replaceAll("[\n\r]", "");
StreamSource requestMessage = new StreamSource(new StringReader(xmlRequest));
wsTemplate.sendSourceAndReceive("wsUrl", requestMessage,new new SoapActionCallback("verifySignature"),new CustomSourceExtractor());