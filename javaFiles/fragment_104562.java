import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

final public class Foo {

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> {
            final DefaultListModel<String> valueListModel = new DefaultListModel<>();
            final JList<String> valueList = new JList<>(valueListModel);
            final DefaultListModel<String> keyListModel = new DefaultListModel<>();
            for (String key : Foo.DATA.keySet()) {
                keyListModel.addElement(key);
            }
            final JList<String> keyList = new JList<>(keyListModel);
            keyList.addListSelectionListener(e -> {
                if (e.getValueIsAdjusting()) {
                    valueListModel.clear();
                    final String key = keyList.getSelectedValue();
                    if (key != null) {
                        for (String value : Foo.DATA.get(key)) {
                            valueListModel.addElement(value);
                        }
                    }
                }
            });

            keyList.setVisibleRowCount(25);
            valueList.setVisibleRowCount(25);
            String prototypeFormat = "%100s";
            keyList.setPrototypeCellValue(String.format(prototypeFormat, " "));
            valueList.setPrototypeCellValue(String.format(prototypeFormat, " "));
            final JPanel contentPane = new JPanel(new GridLayout(1, 0, 0, 0));
            contentPane.add(new JScrollPane(keyList));
            contentPane.add(new JScrollPane(valueList));
            final JFrame window = new JFrame();
            window.setContentPane(contentPane);
            window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            // window.setMinimumSize(new Dimension(1200, 1000));
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        });
    }

    final private static Random RAND = new Random(0);
    final private static Map<String, List<String>> DATA = createDataMap();

    private static Map<String, List<String>> createDataMap() {
        final Map<String, List<String>> ret = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            final int listSize = 20 + RAND.nextInt(5000);
            final String key = generateRandomString('A');
            final List<String> value = new ArrayList<>(listSize);
            ret.put(key, value);
            for (int ii = 0; ii < listSize; ii++) {
                value.add(generateRandomString('a'));
            }
        }
        return ret;
    }

    private static String generateRandomString(final char baseChar) {
        final StringBuilder sb = new StringBuilder();
        final int len = 4 + RAND.nextInt(17);
        for (int i = 0; i < len; i++) {
            sb.append((char) (baseChar + RAND.nextInt(26)));
        }
        return sb.toString();
    }
}