ItemListener il = new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            System.out.println("Hamburger = " + hamburgerJButton.isSelected());
            System.out.println("Pizza = " + pizzaJButton.isSelected());
            System.out.println("Salad = " + saladJButton.isSelected());
        }
    }
};