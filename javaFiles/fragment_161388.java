public class RunMe {

    public static final int AGENT_INFO_START=12;

    public static void main(String[] args) {

        int i=0;
        StringBuffer logElement = new StringBuffer();
        ArrayList<String> logElements = new ArrayList<String>();
        String string = new String("06-09-2013 14:22:33 127.0.0.1 - 127.0.0.1 80 GET 304 207 410 HTTP/1.1 127.0.0.1 Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:21.0) Gecko/20100101 Firefox/21.0 cs_vi=- cs_uuid=- cs_si=- http://clickstream.local/");         

        String[] elements = string.split("\\s");
        for(String element : elements) {
            logElement.append(element);
            i++;
            if(i > AGENT_INFO_START && i < elements.length-4) {
                logElement.append(" ");
            } else {
                logElements.add(logElement.toString());
                logElement.setLength(0);
            }

        }

        for(String element : logElements) {
            System.out.println("Field: " + element);
        }
    }
}