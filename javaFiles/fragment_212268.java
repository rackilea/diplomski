public class InputPanel {
    public InputPanel() {
        this.setLayout(new BorderLayout());
        this.add(new DetailsPanel(), BorderLayout.WEST);
        this.add(new CrimePanel(), BorderLayout.NORTH);
        this.add(new ButtonPanel(), BorderLayout.CENTER);
    }
}

public class DetailsPanel {

    JLabel nameLabel;
    JTextField nameField;
    // ...

    public DetailsPanel() {
        this.setLayout(new GridLayout(5, 1));

        nameLabel = new JLabel("Name");
        nameField = new JTextField();
        // ...

        this.add(nameLabel);
        this.add(nameField);
        // ...
    }
}

...