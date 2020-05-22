final AnalyzingQueryParser analyzingQueryParser = new AnalyzingQueryParser("", analyzer);

// TODO: The rewrite method can be overridden.
// analyzingQueryParser.setMultiTermRewriteMethod(MultiTermQuery.CONSTANT_SCORE_BOOLEAN_REWRITE);

Query parsedQuery = analyzingQueryParser.parse(query);
// Here parsedQuery is an instance of the org.apache.lucene.search.WildcardQuery class.

parsedQuery = parsedQuery.rewrite(reader);
// Here parsedQuery is an instance of the org.apache.lucene.search.MultiTermQueryConstantScoreWrapper class.

final Weight weight = parsedQuery.createWeight(searcher, false);
final Set<Term> terms = new HashSet<>();
weight.extractTerms(terms);