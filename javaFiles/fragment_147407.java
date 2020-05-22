package utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Michael
 * Creation date 12/6/2016.
 * @link https://stackoverflow.com/questions/41006856/how-do-i-catch-a-nosuchelementexception?noredirect=1#comment69222264_41006856
 */
public class StringUtilsTest {

    @Test
    public void testIsNotBlankOrNull_NullString() {
        Assert.assertFalse(StringUtils.isNotBlankOrNull(null));
    }

    @Test
    public void testIsNotBlankOrNull_EmptyString() {
        Assert.assertFalse(StringUtils.isNotBlankOrNull(""));
    }

    @Test
    public void testIsNotBlankOrNull_BlankString() {
        Assert.assertFalse(StringUtils.isNotBlankOrNull("        "));
    }

    @Test
    public void testIsNotBlankOrNull_FullString() {
        Assert.assertTrue(StringUtils.isNotBlankOrNull("I'm not null, blank, or empty"));
    }

    @Test
    public void testTokenize_NullString() {
        // setup
        List<String> expected = Collections.EMPTY_LIST;
        // exercise
        List<String> actual = StringUtils.tokenize(null);
        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTokenize_EmptyString() {
        // setup
        List<String> expected = Collections.EMPTY_LIST;
        // exercise
        List<String> actual = StringUtils.tokenize("");
        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTokenize_BlankString() {
        // setup
        List<String> expected = Collections.EMPTY_LIST;
        // exercise
        List<String> actual = StringUtils.tokenize("        ");
        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTokenize_FullString() {
        // setup
        List<String> expected = Arrays.asList("I'm", "not", "null,", "blank,", "or", "empty");
        // exercise
        List<String> actual = StringUtils.tokenize("    I'm not     null,    blank, or empty    ");
        // assert
        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasSufficientTokens_NegativeTokens() {
        // setup
        int numTokens = -1;
        String str = "    I'm not     null,    blank, or empty    ";
        // exercise
        // assert
        Assert.assertFalse(StringUtils.hasSufficientTokens(numTokens, str));
    }

    @Test
    public void hasSufficientTokens_InsufficientTokens() {
        // setup
        String str = "    I'm not     null,    blank, or empty    ";
        int numTokens = StringUtils.tokenize(str).size() + 1;
        // exercise
        // assert
        Assert.assertFalse(StringUtils.hasSufficientTokens(numTokens, str));
    }

    @Test
    public void hasSufficientTokens_NullString() {
        // setup
        String str = "";
        int numTokens = StringUtils.tokenize(str).size();
        // exercise
        // assert
        Assert.assertTrue(StringUtils.hasSufficientTokens(numTokens, str));
    }

    @Test
    public void hasSufficientTokens_Success() {
        // setup
        String str = "    I'm not     null,    blank, or empty    ";
        int numTokens = StringUtils.tokenize(str).size();
        // exercise
        // assert
        Assert.assertTrue(StringUtils.hasSufficientTokens(numTokens, str));
    }

    @Test
    public void testGetCharFrequencies_NullText() {
        // setup
        String text = null;
        Map<String, Long> expected = new TreeMap<>();
        // exercise
        Map<String, Long> actual = StringUtils.getCharFrequencies(text);
        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCharFrequencies_BlankText() {
        // setup
        String text = "        ";
        Map<String, Long> expected = new TreeMap<>();
        // exercise
        Map<String, Long> actual = StringUtils.getCharFrequencies(text);
        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCharFrequencies_Success() {
        // setup
        String text = "The quick brown fox jumped over the lazy dog!        ";
        String expectedString = "{T=1,  =16, !=1, a=1, b=1, c=1, d=2, e=4, f=1, g=1, h=2, i=1, j=1, k=1, l=1, m=1, n=1, o=4, p=1, q=1, r=2, t=1, u=2, v=1, w=1, x=1, y=1, z=1}";
        // exercise
        Map<String, Long> actual = StringUtils.getCharFrequencies(text);
        // assert
        Assert.assertEquals(expectedString, actual.toString());
    }
}