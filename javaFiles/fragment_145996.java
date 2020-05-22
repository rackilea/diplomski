BooleanQuery fieldTextSubQuery = new BooleanQuery.Builder()
    .add(new WildcardQuery(new Term(fieldText, str), Occur.SHOULD)
    .add(new FuzzyQuery(new Term(fieldText, strTemp), fuzzy), Occur.SHOULD)
    .add(new FuzzyQuery(new Term(fieldText, mergedKeyword), fuzzy), Occur.SHOULD)
    .build();

BooleanQuery finalQuery = new BooleanQuery.Builder()
    .add(new FuzzyQuery(new Term(fieldCity, city), 0), Occur.FILTER)
    .add(textSubQuery, Occur.MUST)
    .build();