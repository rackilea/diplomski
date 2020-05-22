public class Start
{
    public static class ButtonCellEditor extends AbstractCellEditor implements TreeCellEditor, ActionListener, MouseListener
    {
        private JButton button;
        private JLabel label;
        private JPanel panel;
        private Object value;

        public ButtonCellEditor(){
            panel = new JPanel(new BorderLayout());
            button = new JButton("Press me!");
            button.addActionListener(this);
            label = new JLabel();
            label.addMouseListener(this);
            panel.add(button, BorderLayout.EAST);
            panel.add(label);
        }

        @Override public Object getCellEditorValue(){
            return value.toString();
        }

        @Override public void actionPerformed(ActionEvent e){
            String val = value.toString();
            System.out.println("Pressed: " + val);
            stopCellEditing();
        }

        @Override public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row){
            this.value = value;
            label.setText(value.toString());
            return panel;
        }

        @Override public void mouseClicked(MouseEvent e){
        }

        @Override public void mousePressed(MouseEvent e){
            String val = value.toString();
            System.out.println("Clicked: " + val);
            stopCellEditing();
        }

        @Override public void mouseReleased(MouseEvent e){
        }

        @Override public void mouseEntered(MouseEvent e){
        }

        @Override public void mouseExited(MouseEvent e){
        }

    }

    public static class ButtonCellRenderer extends JPanel implements TreeCellRenderer
    {
        JButton button;
        JLabel label;

        ButtonCellRenderer(){
            super(new BorderLayout());
            button = new JButton("Press me!");
            label = new JLabel();
            add(button, BorderLayout.EAST);
            add(label);
        }

        @Override public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus){
            label.setText(value.toString());
            return this;
        }

    }

    public static void main(String[] args){
        JTree tree = new JTree();
        tree.setEditable(true);
        tree.setCellRenderer(new ButtonCellRenderer());
        tree.setCellEditor(new ButtonCellEditor());

        JFrame test = new JFrame();
        test.add(new JScrollPane(tree));
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(500, 500);
        test.setLocationRelativeTo(null);
        test.setVisible(true);
    }
}