// Don't use Container, use JPanel instead, mixing heavy and light weight components
// is never a good idea :P
public class GAListRendererAdv extends JPanel implements ListCellRenderer {
    private static final long serialVersionUID = 1L;
    private JPanel pnl = new JPanel();
    private Random rnd = new Random();

    private JCheckBox checkBox;

    public GAListRendererAdv() {

        setLayout(new BorderLayout(0, 0));            
        checkBox = new JCheckBox();

        add(checkBox, BorderLayout.NORTH);
        add(new JSeparator(), BorderLayout.CENTER);

        pnl = new JPanel(new GridLayout(0, 1, 0, 0));
        pnl.setBorder(new EmptyBorder(0, 35, 0, 0));

        add(pnl BorderLayout.SOUTH); // Don't forget to add the panel :P

    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        pnl.removeAll();
        int rndNum = rnd.nextInt(5) + 1;

        for (int i = 0; i < rndNum; i ++) {
            JLabel lblNewLabel2 = new JLabel("New label");
            pnl.add(lblNewLabel2);
        }

        return this;
    }