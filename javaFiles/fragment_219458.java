//here is the trick
URL policyFileURL = Class.class.getResource("/server/model/easy.policy");
String policyFilePath = "";
try {
    policyFilePath = URLDecoder.decode(policyFileURL.getFile(), "UTF-8");
}
catch (UnsupportedEncodingException e) {}

//here what I wanted to do (now it works)
server.activate(port, new File(policyFilePath));