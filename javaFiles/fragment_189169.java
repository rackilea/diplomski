import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.KeywordTokenizer;


  ...
  Analyzer a = new Analyzer() {
    @Override
    public TokenStreamComponents createComponents(
               String fieldName, Reader reader) {
      Tokenizer tokenizer = new KeywordTokenizer(reader);
      return new TokenStreamComponents(tokenizer, 
                 new IndonesianStemFilter(tokenizer));
    }
  };