public char[] toArrayOfChar()
{
    return new StringBuilder()
        .append(from).append(CRLF)
        .append(to).append(CRLF)
        .append(header).append(CRLF)
        .append(body).append(CRLF)
        .append(header).append(CRLF)
        .toString()
        .toCharArray();
}