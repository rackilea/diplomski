import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.FilteringTokenFilter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public final class ByteLengthFilter extends FilteringTokenFilter {

  private final int min;
  private final int max;
  private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);

  public ByteLengthFilter(TokenStream in, int min, int max) {
    super(in);
    if (min < 0) {
      throw new IllegalArgumentException("minimum length must be greater than or equal to zero");
    }
    if (min > max) {
      throw new IllegalArgumentException("maximum length must not be greater than minimum length");
    }
    this.min = min;
    this.max = max;
  }

  @Override
  public boolean accept() {
    final int len = Charset.forName("UTF-8").encode(CharBuffer.wrap(termAtt)).remaining();
    return (len >= min && len <= max);
  }
}