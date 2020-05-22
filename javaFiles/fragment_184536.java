import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class SimpleParser {
    public static void main(String[] args) throws IOException {
        final Document document = Jsoup.parse(new File("div.html"), "UTF-8");
        final Elements elements = document.select("div.pane.big pre");

        System.out.println("JDK 1.8 style");
        System.out.println(
                stream(elements.html().split("\\s+<a.+</a>\\s+"))
                        .skip(1)
                        .collect(joining("\n")
                        ));

        System.out.println("\nJDK 1.7 style");
        String[] textParts = elements.html().split("\\s+<a.+</a>\\s+");
        StringBuilder resultText = new StringBuilder();
        for (int i = 1; i < textParts.length; i++) {
            resultText.append(textParts[i] + "\n");
        }
        System.out.println(resultText.toString());
    }
}