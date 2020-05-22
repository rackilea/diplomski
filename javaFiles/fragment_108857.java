public class SkillPane extends JPanel {

    private JSpinner spinner;
    private JLabel[] messages;
    private int skillPoints;
    private int currLevel;

    public SkillPane(final int currLevel, final int maxLevel, final int skillPoint) {
        spinner = new JSpinner(new SpinnerNumberModel(currLevel, currLevel, maxLevel, 1));
        this.skillPoints = skillPoint;
        this.currLevel = currLevel;

        messages = new JLabel[]{new JLabel(), new JLabel(), new JLabel()};
        updateMessages();

        setBorder(new EmptyBorder(4, 4, 4, 4));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(messages[0], gbc);
        add(messages[1], gbc);
        add(messages[2], gbc);
        add(spinner, gbc);

        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                updateMessages();
            }
        });
    }

    public int getValue() {
        return (int) spinner.getValue();
    }

    public void updateMessages() {
        int valueChanged = (Integer) spinner.getValue() - currLevel;
        messages[0].setText("Current skill level: " + spinner.getValue());

        if ((skillPoints - valueChanged) > 0) {
            messages[1].setText("Do you want to upgrade this skill to level " + (currLevel + 1) + "?");
        } else {
            messages[1].setText("You do not have enough skill point to upgrade this skill!");
        }

        messages[2].setText("Cost: 1 skill point\nYou have: " + (skillPoints - valueChanged) + " skill point(s) left");
    }

}