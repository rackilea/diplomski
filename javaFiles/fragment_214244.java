public final class PayloadGeneratorFilter extends TokenFilter {
  private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
  private final PayloadAttribute payAtt = addAttribute(PayloadAttribute.class);
  private final PayloadGenerator payloadGenerator;
  private final FrequencyClassDigest frequencyClassDigest;


  public PayloadGeneratorFilter(TokenStream input, PayloadGenerator payloadGenerator,
                                FrequencyClassDigest frequencyClassDigest) {
    super(input);
    this.payloadGenerator = payloadGenerator;
    this.frequencyClassDigest = frequencyClassDigest;
  }

  @Override
  public boolean incrementToken() throws IOException {
    if (input.incrementToken()) {
      final char[] buffer = termAtt.buffer();
      final int length = termAtt.length();
      String token = buffer.toString();
      byte[] payloadBytes = payloadGenerator.generatePayload(token, frequencyClassDigest);
      payAtt.setPayload(new Payload(payloadBytes));
      return true;
    }

    return false;
  }
}