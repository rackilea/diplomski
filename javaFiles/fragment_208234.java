import java.text.ParseException;
import java.util.Objects;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;

public class FormatterMain {

    public static class CustomFormatter extends AbstractFormatter {
        private static final String INFINITE_TEXT = "Infinite";
        private static final Object INFINITE_VALUE = -1;

        @Override
        public Object stringToValue(final String text) throws ParseException {
            try {
                if (Objects.equals(text, INFINITE_TEXT))
                    return INFINITE_VALUE;
                return Integer.valueOf(text);
            }
            catch (final NumberFormatException nfx) {
                //Find where in the string is the parsing error (so as to return ParseException accordingly).
                int i = 0;
                for (final int cp: text.codePoints().toArray()) {
                    if (!Character.isDigit(cp))
                        throw new ParseException("Not a digit.", i);
                    ++i;
                }
                //Should not happen:
                throw new ParseException("Failed to parse input \"" + text + "\".", 0);
            }
        }

        @Override
        public String valueToString(final Object value) throws ParseException {
            if (Objects.equals(value, INFINITE_VALUE))
                return INFINITE_TEXT;
            return Objects.toString(value);
        }
    }

    public static class CustomFormatterFactory extends AbstractFormatterFactory {
        @Override
        public AbstractFormatter getFormatter(final JFormattedTextField tf) {
            if (!(tf.getFormatter() instanceof CustomFormatter))
                return new CustomFormatter();
            return tf.getFormatter();
        }
    }

    public static void main(final String[] args) {
        final JSpinner spin = new JSpinner(new SpinnerNumberModel(0, -1, Integer.MAX_VALUE, 1));

        ((DefaultEditor) spin.getEditor()).getTextField().setFormatterFactory(new CustomFormatterFactory());

        final JFrame frame = new JFrame("JSpinner infinite value");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(spin);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}