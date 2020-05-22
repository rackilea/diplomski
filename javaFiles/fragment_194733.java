String string = "Call me Peter .Call me John.";
Matcher matcher = Pattern.compile ("Call me ([^\r\n\0\\. ]+)\\.").matcher (string);
if (matcher.find ())
{
    String name = matcher.group (1);
    if (matcher.find ()) throw new Exception ("Prohibited: too many matches!");
    System.out.println (name);
}
else throw new Exception ("Prohibited: no matches!");