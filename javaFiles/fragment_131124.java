StringBuilder buffer = new StringBuilder ();
String delim = "";
for (Object o: list)
{
    buffer.append (delim);
    delim = ", "; // Avoid if(); assignment is very fast!
    buffer.append (o);
}
buffer.toString ();