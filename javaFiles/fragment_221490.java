BufferedReader reader = new BufferedReader (
    new InputStreamReader (
        new URL ("https://www.maverik.com/locations/").
            openStream ()));

Pattern linePattern = Pattern.compile ("<b>Maverik Store ([^<]*)</b><br/>([^<]*)<br>([^<]*)<br>([^<]*)<br><center><b></b></center><br /><font color=red>Fuel Prices -- Updated every 30 minutes</font>");
Pattern pricePattern = Pattern.compile ("<div style=\\\\\"float: left;width: 30%;\\\\\">([^<]*)</div><div style=\\\\\"float: left; width: 30%; text-align:center;\\\\\">([^<]*)</div><div style=\\\\\"float: right; width: 30%; text-align:center;\\\\\">([^<]*)</div><br />");

String line;
while ((line = reader.readLine ()) != null)
{
    Matcher lineMatcher = linePattern.matcher (line);
    if (lineMatcher.find ())
    {
        System.out.println ("Store #: " + lineMatcher.group (1));
        System.out.println ("Store Address 1: " + lineMatcher.group (2));
        System.out.println ("Store Address 2: " + lineMatcher.group (3));
        System.out.println ("Store Phone: " + lineMatcher.group (4));

        Matcher priceMatcher = pricePattern.matcher (line);
        while (priceMatcher.find ())
        {
            System.out.println (priceMatcher.group (1) + priceMatcher.group (2) + priceMatcher.group (3));
        }
        System.out.println ();
    }
}