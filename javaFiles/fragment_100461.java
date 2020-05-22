public class Example extends JFrame {

    Example() {

        String[] colNames = new String[] {"Sender", "Subject", "Body"};

        List<String> list = new ArrayList<>();
        list.add("sender@gmail.com");
        list.add("my subject");
        list.add("hiiii");
        list.add("sender2@gmail.com");
        list.add("my subject2");
        list.add("hiiii2");

        String[][] rowData = new String[list.size() / colNames.length][colNames.length];
        for (int i = 0; i < rowData.length; i++) {
            for (int j = 0; j < rowData[i].length; j++) {
                rowData[i][j] = list.get(i * colNames.length + j);
            }
        }

        JTable table = new JTable(rowData, colNames);

        add(new JScrollPane(table));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Example();
    }
}