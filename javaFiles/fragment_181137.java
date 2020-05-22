String a = "member;range=12001-*: CN=marimar,OU=Employees,OU=Cisco
    Users,DC=cisco,DC=com, CN=cadautel,OU=Employees,OU=Cisco
    Users,DC=cisco,DC=com CN=rajaki,OU=Employees,OU=Cisco
    Users,DC=cisco,DC=com";
String pattern = "CN=([^,]+)";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(a);
while (m.find()) {
    System.out.println("CN attribute: " + m.group(1) );
}