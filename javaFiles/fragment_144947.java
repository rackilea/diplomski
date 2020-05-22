public static void main(String[] args) {

    Example main = new Example("Example");

}

public Example(String title) {

    super(title);

    JPanel panel = new JPanel();

    panel.setLayout(new FlowLayout());

    JComponent[] components = new JComponent[3];

    components[0] = new JLabel("Hello!");
    components[1] = new JLabel("How are you?");
    components[2] = new JLabel("I am fine. Thanks");

    addComponents(panel, components);

    add(panel);

    setVisible(true);

}

public void addComponents(JComponent target, JComponent[] components) {

    for(JComponent component : components) {

        target.add(component);

    }

}