String strFormat(String template, String str, String... moreStrs)
{
    String[] args = new String[moreStrs.length + 1];

    // fill the array 'args'
    System.arraycopy(moreStrs, 0, args, 0, moreStrs.length);
    args[moreStrs.length] = str;

    return String.format(template, args);
}