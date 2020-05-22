public class ColorButtons {
    // JButton sample.
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");

    // This is used to store the buttons.
    ArrayList<JButton> jbuttons = new ArrayList<JButton>();

    // Boilerplate, as I have no idea what this does.
    private String type = "pencil";
    private String color = "white";

    /**
     * Populate the JButton List on instantiation.
     * 
     * @see ColorButtons#populateJButtonList()
     */
    public ColorButtons() {
        // Populate "jbuttons" ArrayList with JButtons.
        this.populateJButtonList();
    }

    public void colorButton(JButton button) {
        if (type == "pencil") {
            if (color == "gray") {
                button.setBackground(new Color(101, 101, 101));
            } else if (color == "white") {
                button.setBackground(new Color(255, 255, 255));
            } else if (color == "black") {
                button.setBackground(new Color(0, 0, 0));
            } else if (color == "blue") {
                button.setBackground(new Color(0, 0, 255));
            } else if (color == "red") {
                button.setBackground(new Color(255, 0, 0));
            }
        }
    }

    public void buttonArray() {
        JButton[] button = new JButton[100];

        for (int i = 0; i < 100; i++) {
            // Assign each JButton in the list to array element.
            for (JButton jbutton : jbuttons) {
                button[i] = jbutton; // I need to get each of the 100 buttons
                                        // here
                System.out.println("Button" + button[i].getText());
                colorButton(button[i]);
            }
        }
    }

    /**
     * This is used to add the JButtons to a list using reflection. Used in the
     * constructor.
     * 
     * @see ColorButtons#ColorButtons()
     */
    public void populateJButtonList() {
        // Gets the class attributes, e.g. JButton, String, Integer types, everything.
        // In this case it is this class, but can define any other class in your project.
        Field[] fields = ColorButtons.class.getDeclaredFields();

        // Loop over each field to determine if it is a JButton.
        for (Field field : fields) {

            // If it is a JButton then add it to the list.
            if (field.getType().equals(JButton.class)) {
                try {
                    // De-reference the field from the object (ColorButtons) and cast it to a JButton and add it to the list.
                    jbuttons.add((JButton) field.get(this));
                } catch (IllegalArgumentException | IllegalAccessException
                        | SecurityException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String... args) {
        ColorButtons color = new ColorButtons();

        color.buttonArray();
    }
}