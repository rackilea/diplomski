public class SeparatorListTest {

private static Comparator<String> createComparator() {
    return new Comparator<String>() {
        public int compare(String stringOne, String stringTwo) {
            return stringOne.substring(0,1).compareTo(stringTwo.substring(0,1));
        }
    };
}

private static ListCellRenderer createListCellRenderer() {
    return new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof SeparatorList.Separator) {
                SeparatorList.Separator separator = (SeparatorList.Separator) value;
                label.setText(separator.getGroup().get(0).toString().substring(0,1));
                label.setFont(label.getFont().deriveFont(Font.BOLD));
                label.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
            } else {
                label.setFont(label.getFont().deriveFont(Font.PLAIN));
                label.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));
            }

            return label;
        }
    };
}

public static void main(String[] args) {
    EventList<String> rawList = GlazedLists.eventListOf(
            "apple", "appricot", "acorn", "blueberry", "coconut", "chesnut", "grape");
    SeparatorList<String> separatorList = 
            new SeparatorList<String>(rawList, createComparator(), 1, 1000);

    JList list = new JList(new EventListModel<String>(separatorList));
    list.setCellRenderer(createListCellRenderer());
    JScrollPane scrollPane = new JScrollPane(list);
    scrollPane.setBorder(null);

    JFrame frame = new JFrame();
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,200);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}