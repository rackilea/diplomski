import java.time.Duration;
 import java.util.Collection;
 import java.util.Collections;
 import java.util.concurrent.ExecutorService;
 import java.util.concurrent.Executors;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 import javafx.concurrent.Task;
 import org.fxmisc.richtext.CodeArea;
 import org.fxmisc.richtext.PlainTextChange;
 import org.fxmisc.richtext.StyleSpans;
 import org.fxmisc.richtext.StyleSpansBuilder;
 import org.reactfx.EventStream;

 /**
  *
  * @author Nika
  */
 public class SyntaxTextArea {

 private static final String[] KEYWORDS = new String[]{
    "abstract", "assert", "boolean", "break", "byte",
    "case", "catch", "char", "class", "const",
    "continue", "default", "do", "double", "else",
    "enum", "extends", "final", "finally", "float",
    "for", "goto", "if", "implements", "import",
    "instanceof", "int", "interface", "long", "native",
    "new", "package", "private", "protected", "public",
    "return", "short", "static", "strictfp", "super",
    "switch", "synchronized", "this", "throw", "throws",
    "transient", "try", "void", "volatile", "while"
 };

 private static final Pattern KEYWORD_PATTERN = Pattern.compile("\\b(" +    String.join("|", KEYWORDS) + ")\\b");

private CodeArea codeArea;
private ExecutorService executor;

public SyntaxTextArea() {

    executor = Executors.newSingleThreadExecutor();
    codeArea = new CodeArea();
    EventStream<PlainTextChange> textChanges = codeArea.plainTextChanges();
    textChanges
            .successionEnds(Duration.ofMillis(500))
            .supplyTask(this::computeHighlightingAsync)
            .awaitLatest(textChanges)
            .subscribe(this::applyHighlighting);

   codeArea.getStylesheets().add(org.fxmisc.richtext.demo.JavaKeywordsAsync.class.getResource("java-keywords.css").toExternalForm());
}

public void setText(String text) {
    codeArea.replaceText(0, 0, text);

}

public String getText() {
  return  codeArea.getText();

}
public void appendText(String text) {
    codeArea.appendText(text);

}

public  CodeArea getNode(){
return codeArea;
}

public void setStyling(){

}
private Task<StyleSpans<Collection<String>>> computeHighlightingAsync() {
    String text = codeArea.getText();
    Task<StyleSpans<Collection<String>>> task = new Task<StyleSpans<Collection<String>>>() {
        @Override
        protected StyleSpans<Collection<String>> call() throws Exception {
            return computeHighlighting(text);
        }
    };
    executor.execute(task);
    return task;
}

private void applyHighlighting(StyleSpans<Collection<String>> highlighting) {
    codeArea.setStyleSpans(0, highlighting);
}

private static StyleSpans<Collection<String>> computeHighlighting(String text) {
    Matcher matcher = KEYWORD_PATTERN.matcher(text);
    int lastKwEnd = 0;
    StyleSpansBuilder<Collection<String>> spansBuilder
            = new StyleSpansBuilder<>();
    while (matcher.find()) {
        spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
        spansBuilder.add(Collections.singleton("keyword"), matcher.end() - matcher.start());
        lastKwEnd = matcher.end();
    }
    spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
    return spansBuilder.create();
}

 }