public class ButtonEditor extends DefaultCellEditor
{
    protected JButton button;

    public ButtonEditor(JCheckBox checkBox) 
    {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                button.setBackground(Color.GREEN);
                button.repaint();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
        boolean isSelected, int row, int column) 
    {
        return button;
    }

}