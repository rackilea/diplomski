public static void main(String[] args) {
    final String str = "\"User1\":\"<?xml version=\"1.0\"?><presence xmlns=\"urn:ietf:params:xml:ns:pidf\" xmlns:dm=\"urn:ietf:params:xml:ns:pidf:data-model\" xmlns:rpid=\"urn:ietf:params:xml:ns:pidf:rpid\" xmlns:c=\"urn:ietf:params:xml:ns:pidf:cipid\" entity=\"ivaxer@tipmeet.com\"></presence>";
    final int firstIndexOfColon = str.indexOf(':');
    if(firstIndexOfColon >= 0) {
        final String key = str.substring(0, firstIndexOfColon);
        final String val = ((firstIndexOfColon + 1) < str.length()) ? str.substring(1 + firstIndexOfColon) : "Empty value string";
        System.out.println(key);
        System.out.println(val);
    } else {
        System.out.println("No delimiter found");
    }
}