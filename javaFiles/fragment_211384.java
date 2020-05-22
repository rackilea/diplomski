public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    sb.append("Name        : mysql                        Relocations: (not relocatable)\n");
    sb.append("Version     : 5.1.61                            Vendor: CentOS\n");
    sb.append("Release     : 4.el6                         Build Date: Fri 22 Jun 2012 05:58:59 AM PDT\n");
    sb.append("Install Date: Tue 13 Nov 2012 02:23:23 AM PST      Build Host: c6b10.bsys.dev.centos.org\n");
    sb.append("URL         : http://www.mysql.com\n");
    sb.append("Summary     : MySQL client programs and shared libraries\n");

    Pattern p = Pattern.compile("([^\\r\\n:]+):\\s(.+?)(\\s{2,}|\\r\\n|\\r|\\n|$)");
    Matcher m = p.matcher(sb.toString());
    while(m.find()) {
        String key = m.group(1).trim();
        String value = m.group(2);

        System.out.println(key + " = \"" + value + "\"");
    }
}