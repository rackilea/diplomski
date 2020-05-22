QueryParser parser = new QueryParser("field", new StandardAnalyzer());
    try {
        Query query = parser.parse("query"); // changed this line
    } catch (ParseException e) {
        e.printStackTrace();
    }