public class TournamentHandler extends DefaultHandler {

    private Tournament tournament;
    private TournamentDay currentDay;
    private Match currentMatch;
    private StringBuilder builder;

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        if (qName.equalsIgnoreCase("team1"))
            currentMatch.setTeam1(builder.toString());
        else if (qName.equalsIgnoreCase("team2"))
            currentMatch.setTeam2(builder.toString());
        else if (qName.equalsIgnoreCase("resultfinal"))
            currentMatch.setResultfinal(builder.toString());
        else if (qName.equalsIgnoreCase("result1"))
            currentMatch.setResult1(builder.toString());
        else if (qName.equalsIgnoreCase("result2"))
            currentMatch.setResult2(builder.toString());
        else if (qName.equalsIgnoreCase("venue"))
            currentMatch.setVenue(builder.toString());
        else if (qName.equalsIgnoreCase("gmt"))
            currentMatch.setGmt(builder.toString());
        else if (qName.equals("match"))
            currentDay.add(currentMatch);
        else if (qName.equals("day"))
            tournament.add(currentDay);
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equals("data")) {
            tournament = new Tournament();
        }
        if (qName.equals("day")) {
            currentDay = new TournamentDay();
        }
        else if (qName.equals("match")) {
            currentMatch = new Match();
        }
        else {
            builder = new StringBuilder();
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        builder.append(chars, start, length);
    }

    public Tournament getTournament() {
        return tournament;
    }
}