public class TestPane extends JPanel {

    private EmployeeTableModel model = new EmployeeTableModel();

    public TestPane() {
        setLayout(new BorderLayout());
        add(new JScrollPane(new JTable(model)));

        JButton add = new JButton("Add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = model.getRowCount();
                EmployeeDetails ed = new EmployeeDetails("Employee " + row, "@ " + row, "Metro" + row, Integer.toString(row));
                model.add(ed);
            }
        });
        add(add, BorderLayout.SOUTH);
    }

}