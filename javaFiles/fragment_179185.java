public setHeader(String code, String username)
{
    StringBuilder sb = new StringBuilder(username);
    sb.append(":");
    sb.append(code);
    sb = new StringBuilder(Base64.encodeToString(sb.toString().getBytes(), Base64.DEFAULT));
    sb.insert(0, "Basic ");
    auth = sb.toString();
}