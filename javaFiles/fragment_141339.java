public static void main(final String[] args) throws IOException
{
    final String url = "http://poslovno.com/kategorije.html?sobi2Task=sobi2Details&catid=71&sobi2Id=20001";
    final Document doc = Jsoup.connect(url).get();
    final Element e5 = doc.getElementById("sobi2Details_field_email");

    System.out.println("--- this is how we start");
    System.out.println(e5 + "\n\n\n\n");

    // remove the xml encoding
    System.out.println("---Remove XML encoding\n");
    String email = org.jsoup.parser.Parser.unescapeEntities(e5.toString(), false);
    System.out.println(email + "\n\n\n\n");

    // remove the concatunation with ' + '
    System.out.println("--- Remove concatunation (all: ' + ')");
    email = email.replaceAll("' \\+ '", "");
    System.out.println(email + "\n\n\n\n");

    // extract the email address variables
    System.out.println("--- Remove useless lines");
    Matcher matcher = Pattern.compile("var addy.*var addy", Pattern.MULTILINE + Pattern.DOTALL).matcher(email);
    matcher.find();

    email = matcher.group();
    System.out.println(email + "\n\n\n\n");

    // get the to string enclosed by '' and concatunate
    System.out.println("--- Extract the email address");
    matcher = Pattern.compile("'(.*)'.*'(.*)'", Pattern.MULTILINE + Pattern.DOTALL).matcher(email);
    matcher.find();

    email = matcher.group(1) + matcher.group(2);
    System.out.println(email);

}