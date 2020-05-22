Pattern token = Pattern.compile("([{}]|,|[A-Aa-z0-9]+|\s+)");
int nesting = 0
Matcher m = token.matcher(inputString);
while(m.find())
{
    if (m.group(1).equals("{")
        nesting++;
    else if (m.group(1).equals("}")
    {
        nesting--;
        if (nesting < 0)
            error - too many right braces
    }
    else
        ....
}
if (nesting != 0) 
    log("incorrect nesting");