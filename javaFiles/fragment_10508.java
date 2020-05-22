String dayOption = (String)JOptionPane.showInputDialog(frame,"Pick a day you wish to display the records for : ", "Catagory pick", JOptionPane.PLAIN_MESSAGE, null, possibilities,"ham");

int chosenDay = Integer.parseInt(dayOption);
for (SalesData item : array) {
    if (item.day == chosenDay) {
        // ...
    }
}