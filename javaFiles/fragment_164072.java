// Put all values into a map. If the mentioned fruit has the mentioned
// color, then the answer is correct.
private Map<JToggleButton, Boolean> correctAnswers = new HashMap<JToggleButton, Boolean>() {{
    put(new JToggleButton("A strawberry is red"), true);
    put(new JToggleButton("A banana is blue"), false);
    put(new JToggleButton("A lemon is yellow"), true);
    put(new JToggleButton("An orange is orange"), true);
}};

void init() {
    for (JToggleButton button : map.keySet()) {
        // button.setActionListener(this); // The toggle buttons themselves
        // do not need to have a listener, do they? Only when the user clicks
        // "go", then the buttons should be evaluated, right?
        myJPanel.add(button);
    }
    JButton submitButton = new JButton("go");
    submitButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent event) {
            boolean wrong = false; // It's all good now, until a wrong
            // answer is found.

            // Iterate over all entries of our map.
            for (JToggleButton button : this.buttons.keySet()) {
                // Check if the selection state of the toggle button is
                // equal to whether the answer is yes or no.
                if (button.isSelected() != this.buttons.get(button)) {
                    // A button is pressed while it should not be pressed
                    // OR vice versa. Let's mark that at least one button
                    // is incorrect.
                    wrong = true;
                }
            }

            // We found at least one incorrect button.
            if (wrong) {
                // DO SOMETHING
            }
        }
    });
    myJPanel.add(submitButton);
}