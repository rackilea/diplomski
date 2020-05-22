import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HtmlHighlighter {
  private final String inputWithoutTags;
  private final List<Tag> tags;

  private static class Tag {
    private final String text;
    private final int startPos;

    private Tag(final String text, final int startPos) {
      this.text = text;
      this.startPos = startPos;
    }
  }

  public HtmlHighlighter(final String input, final String tagRegex) {
    final Pattern p = Pattern.compile(tagRegex);
    tags = new ArrayList<>();
    final Matcher m = p.matcher(input);
    StringBuffer sb = new StringBuffer();
    int cursor = 0;
    int cursorExcludingTags = 0;
    while (m.find()) {
      cursorExcludingTags += m.start() - cursor;
      tags.add(new Tag(input.substring(m.start(), m.end()), cursorExcludingTags));
      cursor = m.end();
      m.appendReplacement(sb, "");
    }
    m.appendTail(sb);
    inputWithoutTags = sb.toString();
  }

  public String highlightText(String regexToFind, String openingTag, String closingTag) {
    final List<Tag> allTags = getAllTags(regexToFind, openingTag, closingTag);
    return combineTags(allTags);
  }

  private List<Tag> getAllTags(final String regexToFind, final String openingTag, final String closingTag) {
    final List<Tag> ret = new ArrayList<>(tags);
    final Pattern p = Pattern.compile(regexToFind);
    final Matcher m = p.matcher(inputWithoutTags);
    while (m.find()) {
      addTag(new Tag(openingTag, m.start()), true, ret);
      addTag(new Tag(closingTag, m.end()), false, ret);
    }
    return ret;
  }

  private void addTag(final Tag tag, final boolean beforeIgnored, final List<Tag> allTags) {
    for (int i = 0; i < allTags.size(); i++) {
      if (allTags.get(i).startPos >= tag.startPos && beforeIgnored) {
        allTags.add(i, tag);
        return;
      }
      if (allTags.get(i).startPos > tag.startPos) {
        allTags.add(i, tag);
        return;
      }
    }
    allTags.add(allTags.size(), tag);
  }

  private String combineTags(final List<Tag> allTags) {
    final StringBuilder sb = new StringBuilder(inputWithoutTags);
    for (int i = allTags.size() - 1; i >= 0; i--) {
      final Tag tag = allTags.get(i);
      sb.insert(tag.startPos, tag.text);
    }
    return sb.toString();
  }

  public static void main(String... args) {
    final HtmlHighlighter highlighter = new HtmlHighlighter("This is a test text with <span>it<span>al<span>ic</span> and etc.", "\\<.*?\\>");
    System.out.println(highlighter.highlightText("italic", "<span class='highlight'>", "</span>"));
  }
}