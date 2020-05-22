@Component
public class PanelImpl implements Panel {

    @Autowired
    private JPanel panel;

    @Autowired
    private JButton getInfoBtn;

    @PostConstruct
    private void setPanel() {
        getInfoBtn.setText("Get Info");
        panel.add(getInfoBtn);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}