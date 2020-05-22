if (button_command.equals("No Change")) {
    LocalDate newbDate = pickin.getDateValue();

    display_Area.setText("The date is " + newbDate);
    display_Area.setFont(new Font("Serif", Font.BOLD, 18));
    display_Area.setForeground(Color.black);
}