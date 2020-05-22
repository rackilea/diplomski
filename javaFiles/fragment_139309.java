public class SwitchTableModel extends AbstractTableModel {
    private final String [] name = new String [] {"Alice", "Bob", "John", "Mary"};
    private final String [] surname = new String [] {"Green", "Red", "Brown", "Grey"};

    private final int [][] data = new int [][] {
        new int [] {1, 3, 2},
        new int [] {0, 2, 1, 3},
        new int [] {0, 3},
        new int [] {0, 1, 2, 3}
    };

    private int position = 0;

    @Override
    public int getRowCount() {
        return 2;
    }

    @Override
    public int getColumnCount() {
        return data [position].length + 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (rowIndex)
        {
        case 0:
            return columnIndex == 0 ? "Name" : name [data [position][columnIndex - 1]];
        case 1:
            return columnIndex == 0 ? "Surname" : surname [data [position][columnIndex - 1]];
        default:
            throw new Error ();
        }
    }

    public void previous ()
    {
        position -= 1;
        if (position < 0) position = data.length - 1;

        fireTableStructureChanged();
    }

    public void next ()
    {
        position += 1;
        if (position >= data.length) position = 0;

        fireTableStructureChanged();
    }

    public static void main(String[] args) {
        final SwitchTableModel model = new SwitchTableModel();

        Box toolbar = Box.createHorizontalBox();
        toolbar.add (new JButton (new AbstractAction("Previous") {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.previous ();
            }
        }));
        toolbar.add (Box.createHorizontalGlue());
        toolbar.add (new JButton (new AbstractAction("Next") {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.next ();
            }
        }));

        JTable table = new JTable(model);

        JFrame frame = new JFrame ();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add (toolbar, BorderLayout.NORTH);
        frame.getContentPane().add (
            new JScrollPane(
                table, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),    
            BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}