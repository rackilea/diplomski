StringBuilder str = new StringBuilder();
if (numhundreds > 0)
{
    str.append(ones[numhundreds] + " hundred");
    if (numtens > 0 || numones > 0) str.append(" and ");
}
if (numtens > 0)
{
    if (numones == 1)
    {
        str.append(ones[numtens + numones]);
    } else {
        str.append(tens[numtens]);
        if (numones > 0) str.append(" ");
    }
}
if (numones > 1)
{
    str.append(ones[numones]);
}