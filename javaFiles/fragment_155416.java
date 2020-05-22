String s = "[msg \"Invalid HTTP Request Line\"] [data \"CONNECT www.alipay.com:443 HTTP/1.1\"] [severity \"WARNING\"]";
Pattern pattern = Pattern.compile("\\[msg\\s\"([^\"]+)\"\\]\\s\\[(?:data|severity)");
Matcher m = pattern.matcher(s);
while(m.find())
{
    System.out.println(m.group(1));
}