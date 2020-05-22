public String[] mySplit(final String input, final String delim)
{
    return input.replaceFirst("^" + delim, "").split(delim);
}

String[] test = mySplit("/Test/Stuff", "/");