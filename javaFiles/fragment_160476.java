String inputURL = "http://www.myhost.com";
    String subdomain = "newlocation";

    URL url = new URL(inputURL);

    String[] domainParts = url.getHost().split("\\.");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < domainParts.length; i ++) {
        if (i == 1) {
            sb.append(subdomain + ".");
        }
        sb.append(domainParts[i] + ".");
    }
    String query = "";
    String port = "";
    if (url.getQuery() != null) {
        query = "?" + url.getQuery();
    }
    if (url.getPort() != -1) {
        port = url.getPort() + "";
    }
    String output = url.getProtocol() + ":" + port + "//" + sb.toString() + "/" + url.getPath() + query;
    System.out.println(output);