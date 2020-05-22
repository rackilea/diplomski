public class RunMe {
    public static void main(String[] args) {

        StringBuffer logElement = new StringBuffer();
        ArrayList<String> logElements = new ArrayList<String>();
        String string = new String("06-09-2013 14:22:33 127.0.0.1 - 127.0.0.1 80 GET 304 207 410 HTTP/1.1 127.0.0.1 Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:21.0) Gecko/20100101 Firefox/21.0 cs_vi=- cs_uuid=- cs_si=- http://clickstream.local/");

        // Put "" around all fields.
        String newStr = string.replaceAll("^([0-9-]*)\\s([0-9:]*)\\s([0-9\\\\.]*)\\s(-)\\s([0-9\\\\.]*)\\s([0-9]*)\\s(GET|POST)\\s([0-9]*)\\s([0-9]*)\\s([0-9]*)\\s([a-zA-Z0-9\\\\./]*)\\s([0-9\\\\.]*)\\s(.*)\\s(cs_vi=.*)\\s(cs_uuid=.*)\\s(.*)\\s(.*)", 
                                            "\"$1\" \"$2\" \"$3\" \"$4\" \"$5\" \"$6\" \"$7\" \"$8\" \"$9\" \"$10\" \"$11\" \"$12\" \"$13\" \"$14\" \"$15\" \"$16\" \"$17\"");

        String[] elements = newStr.split("\"");
        for(String element : elements) {
            System.out.println(element);
        }
    }
}