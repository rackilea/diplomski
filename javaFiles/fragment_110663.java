String string = 
    "5163583,601028,30,,0,\"Leaflets, samples\",Cycle 5 objectives,,20100804T071410,";

Matcher m = Pattern.compile ("(\"[^\"]*\"|[^,\"]*)(?:,|$)").matcher (string);

List <String> chunks = new ArrayList <String> ();
while (m.find ())
{
    String chunk = m.group (1);
    if (chunk.startsWith ("\"") && chunk.endsWith ("\""))
        chunk = chunk.substring (1, chunk.length () - 1);
    chunks.add (chunk);
}

String array [] = chunks.toArray (new String [chunks.size ()]);
for (String s: array)
    System.out.println ("'" + s + "'");