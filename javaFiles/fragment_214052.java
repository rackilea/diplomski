public class GetterText extends JFrame {

    GetterText() {

        JList<String> list = new JList<>(new String[]{"AAAA", "BBBB", "CCCC", "DDDD"});
        list.setCellRenderer(new MyListCellRenderer());

        getContentPane().add(list);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private class MyListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setOpaque(isSelected); // Highlight only when selected
            label.setOpaque(true); // Highlight always
            if(index == 2) { // I faked a match for the second index, put you matching condition here.
                label.setBackground(Color.YELLOW);
                label.setEnabled(false);     
            }
            return label;
        }
    }

    public static void main(String[] args) {

        new GetterText();
    }
}