import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InputBlocker extends Application {
    private static final String TEXT =
            "Lorem ipsum: dolor sit amet, consectetur adipiscing elit. Nulla in nisi sed neque porttitor volutpat. \n" +
            "\n" +
            "Lorem ipsum: Maecenas non mauris scelerisque, egestas felis quis, venenatis risus. Etiam eu ornare justo, at pulvinar tortor. ";

    private static final String FORBIDDEN_PREFIX = "Lorem ipsum: ";

    @Override
    public void start(final Stage stage) throws Exception {
        TextArea textArea = new BlockingTextArea(TEXT, FORBIDDEN_PREFIX);
        textArea.setWrapText(true);

        stage.setScene(new Scene(textArea));
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}

class BlockingTextArea extends TextArea {
    private final String forbiddenPrefix;
    private List<Range> blockedRanges;

    public BlockingTextArea(String text, String forbiddenPrefix) {
        super(text);

        this.forbiddenPrefix = forbiddenPrefix;
        this.blockedRanges = findBlockedRanges(text);

        textProperty().addListener((observable, oldValue, newValue) ->
                blockedRanges = findBlockedRanges(newValue)
        );
    }

    @Override
    public void positionCaret(int pos) {
        Optional<Range> blockedRange =
                blockedRanges.stream()
                        .filter(range -> range.containsExclusive(pos))
                        .findFirst();

        if (blockedRange.isPresent()) {
            return;
        }

        super.positionCaret(pos);
    }

    private List<Range> findBlockedRanges(String text) {
        List<Range> blocked = new ArrayList<>();

        int idx = 0;
        while (idx < text.length()) {
            if (text.startsWith(forbiddenPrefix, idx)) {
                blocked.add(new Range(idx, idx + forbiddenPrefix.length()));
                idx += forbiddenPrefix.length();
            }

            int nextIdx = text.indexOf("\n", idx);
            if (nextIdx == -1) {
                break;
            }

            idx = nextIdx + 1;
        }

        return blocked;
    }

    private class Range {
        private final int min;
        private final int max;

        Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        boolean containsExclusive(int pos) {
            return min <= pos && pos < max;
        }
    }
}