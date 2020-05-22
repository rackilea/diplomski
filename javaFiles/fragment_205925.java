String token;
String authorization = getAuthorization(token);

if (authorization != null) {
    String[] parts = authorization.split(" ");
    if (parts.length == 2 && "Bearer".equals(part[0])) {
        token = parts[1];
    }

return token;