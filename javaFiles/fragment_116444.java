public class RequestStr {
    String url = "";

    public RequestStr(ClientSession cSession, String urlKey) {
        super();
        this.url = cSession.getValue(urlKey);
    }

    public String getParameter(String aParam) {
        int i = url.indexOf("?" + aParam + "=");
        if (i == -1) {
            i = url.indexOf("&" + aParam + "=");
        }
        if (i == -1) {
            return null;
        } else {

            int j = url.indexOf("&", i + 1);
            if (j == -1) {
                return url.substring(i + aParam.length() + 2);
            } else {
                return url.substring(i + aParam.length() + 2, j);
            }
        }
    }

}