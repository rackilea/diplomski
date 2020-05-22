JButton [] seats = new JButton[40];

for (int i = 0; i < 40; i++)
{
    final JButton seat = new JButton();
    final int seatingID = i;

    seats[i] = seat;
    seat.setPreferredSize(new Dimension(50,25));
    panel4seating.add(seat);

    seat.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt)
        {  
            String firstName = showInputDialog();
            String lastName = showInputDialog();

            sw101.AddPassenger(firstName, lastName, seatingID);

            seat.setEnabled(false);
        }
    });
}