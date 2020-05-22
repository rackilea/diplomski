import java.util.*;
import java.util.regex.*;

public class RETokenizer
{
  static List<Token> tokenize(String source, List<Rule> rules)
  {
    List<Token> tokens = new ArrayList<Token>();
    int pos = 0;
    final int end = source.length();
    Matcher m = Pattern.compile("dummy").matcher(source);
    m.useTransparentBounds(true).useAnchoringBounds(false);
    while (pos < end)
    {
      m.region(pos, end);
      for (Rule r : rules)
      {
        if (m.usePattern(r.pattern).lookingAt())
        {
          tokens.add(new Token(r.name, m.start(), m.end()));
          pos = m.end();
          break;
        }
      }
      pos++;  // bump-along, in case no rule matched
    }
    return tokens;
  }

  static class Rule
  {
    final String name;
    final Pattern pattern;

    Rule(String name, String regex)
    {
      this.name = name;
      pattern = Pattern.compile(regex);
    }
  }

  static class Token
  {
    final String name;
    final int startPos;
    final int endPos;

    Token(String name, int startPos, int endPos)
    {
      this.name = name;
      this.startPos = startPos;
      this.endPos = endPos;
    }

    @Override
    public String toString()
    {
      return String.format("Token [%2d, %2d, %s]", startPos, endPos, name);
    }
  }

  public static void main(String[] args) throws Exception
  {
    List<Rule> rules = new ArrayList<Rule>();
    rules.add(new Rule("WORD", "[A-Za-z]+"));
    rules.add(new Rule("QUOTED", "\"[^\"]*+\""));
    rules.add(new Rule("COMMENT", "//.*"));
    rules.add(new Rule("WHITESPACE", "\\s+"));

    String str = "foo //in \"comment\"\nbar \"no //comment\" end";
    List<Token> result = RETokenizer.tokenize(str, rules);
    for (Token t : result)
    {
      System.out.println(t);
    }
  }
}