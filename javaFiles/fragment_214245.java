public class NLPPayloadAnalyzer extends Analyzer {
  private PayloadGenerator payloadGenerator;
  private FrequencyClassDigest frequencyClassDigest;

  public NLPPayloadAnalyzer(PayloadGenerator payloadGenerator,
                            FrequencyClassDigest frequencyClassDigest) {
    this.payloadGenerator = payloadGenerator;
    this.frequencyClassDigest = frequencyClassDigest;
  }

  public TokenStream tokenStream(String fieldName, Reader reader) {
    TokenStream tokenStream = new WhitespaceTokenizer(Version.LUCENE_31, reader);
    tokenStream = new PayloadGeneratorFilter(tokenStream, payloadGenerator, frequencyClassDigest);
    return tokenStream;
  }
}