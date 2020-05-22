@Override
String createBindPrincipal(String username) {
    if (domain == null || username.toLowerCase().endsWith(domain)) {
        return username;
    }
    return "NT_DOMAIN\\" + username;
}