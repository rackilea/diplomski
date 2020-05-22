String role = "ROLE_DELETE_USER";
Pattern pattern = Pattern.compile("^ROLE_(.*)_USER$");
Matcher matcher = pattern.matcher(role);
if(matcher.find()) {
    System.out.println(matcher.group(1));
}