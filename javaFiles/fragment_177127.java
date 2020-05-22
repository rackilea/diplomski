import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import com.google.common.collect.Iterators;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.standard.ClassicTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import static vyre.util.search.LuceneVersion.VERSION_IN_USE;

/**
 * Allows to easily manipulate with {@link ClassicTokenizer} by delegating calls to it but hiding all implementation details.
 *
 * @author Mindaugas Žakšauskas
 */
public abstract class ClassicTokenizerDelegate extends Tokenizer {

    private final ClassicTokenizer classicTokenizer;

    private final CharTermAttribute termAtt;

    private final TypeAttribute typeAtt;

    /**
     * Internal buffer of tokens if any of standard tokens was split into many.
     */
    private Iterator<String> pendingTokens = Iterators.emptyIterator();

    protected ClassicTokenizerDelegate(Reader input) {
        super(input);
        this.classicTokenizer = new ClassicTokenizer(VERSION_IN_USE, input);
        termAtt = addAttribute(CharTermAttribute.class);
        typeAtt = addAttribute(TypeAttribute.class);
    }

    /**
     * Is called during tokenization for each token produced by {@link ClassicTokenizer}. Subclasses can call {@link #setTerm(String)} to override
     * current token or {@link #setTerms(Iterator)} if current token needs to be split into more than one token.
     *
     * @return true whether next token exists false otherwise.
     * @see #getTerm()
     * @see #getType()
     * @see #setTerm(String)
     * @see #setTerms(Iterator)
     */
    protected abstract boolean onNextToken();

    /**
     * Subclasses can call this method during execution of {@link #onNextToken()} to retrieve current term.
     *
     * @return current term.
     * @see #getType()
     * @see #setTerm(String)
     * @see #setTerms(Iterator)
     * @see #onNextToken()
     */
    protected String getTerm() {
        return new String(termAtt.buffer(), 0, termAtt.length());
    }

    /**
     * Subclasses can call this method during execution of {@link #onNextToken()} to retrieve type of current term.
     *
     * @return type of current term.
     * @see #getTerm()
     * @see #setTerm(String)
     * @see #setTerms(Iterator)
     * @see #onNextToken()
     */
    protected String getType() {
        return typeAtt.type();
    }

    /**
     * Subclasses can call this method during execution of {@link #onNextToken()} to override current term.
     *
     * @param term the term to override with.
     * @see #getTerm()
     * @see #getType()
     * @see #setTerms(Iterator) setTerms(Iterator) - if you want to override current term with more than one term
     * @see #onNextToken()
     */
    protected void setTerm(String term) {
        termAtt.copyBuffer(term.toCharArray(), 0, term.length());
    }

    /**
     * Subclasses can call this method during execution of {@link #onNextToken()} to override current term with more than one term.
     *
     * @param terms the terms to override with.
     * @see #getTerm()
     * @see #getType()
     * @see #setTerm(String)
     * @see #onNextToken()
     */
    protected void setTerms(Iterator<String> terms) {
        setTerm(terms.next());
        pendingTokens = terms;
    }

    @Override
    public final boolean incrementToken() throws IOException {
        if (pendingTokens.hasNext()) {
            setTerm(pendingTokens.next());
            return true;
        }

        clearAttributes();
        if (!classicTokenizer.incrementToken()) {
            return false;
        }

        typeAtt.setType(classicTokenizer.getAttribute(TypeAttribute.class).type());        // copy type attribute from classic tokenizer attribute

        CharTermAttribute stTermAtt = classicTokenizer.getAttribute(CharTermAttribute.class);
        setTerm(new String(stTermAtt.buffer(), 0, stTermAtt.length()));

        return onNextToken();
    }

    @Override
    public void close() throws IOException {
        super.close();
        if (input != null) {
            input.close();
        }
        classicTokenizer.close();
    }

    @Override
    public void end() throws IOException {
        super.end();
        classicTokenizer.end();
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        this.classicTokenizer.setReader(input);        // important! input has to be carried over to delegate because of poor design of Lucene
        classicTokenizer.reset();
    }
}