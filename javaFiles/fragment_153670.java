public class JListExample extends JPanel {
    private static final int LIST_ROW_COUNT = 20;
    private static final int LIST_CHAR_WIDTH = 80;
    private static final String LIST_PROTOTYPE = "%" + LIST_CHAR_WIDTH + "s";
    private JList<String> list1 = new JList<>();
    private JList<String> list2 = new JList<>();

    public JListExample() {
        list1.setVisibleRowCount(LIST_ROW_COUNT);
        list2.setVisibleRowCount(LIST_ROW_COUNT);
        list1.setPrototypeCellValue(String.format(LIST_PROTOTYPE, ""));
        list2.setPrototypeCellValue(String.format(LIST_PROTOTYPE, ""));