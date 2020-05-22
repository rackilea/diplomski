private static class ButtonHandler implements ActionListener
{
    public void actionPerformed (ActionEvent e)
    {

        if (e.getSource () == btnT1)
        {
            frame2.setVisible (true);
            btnT1.setEnabled (false);
            qTitle.setText ("Solar energy generates electricity from what source?");
            a1.setText ("The water");
            a2.setText ("The sun");
            a3.setText ("Fossil fuels");
            a4.setText ("The wind");

            if (e.getSource () == a2)
            {
                score = score + 100;
                frame2.setVisible (false);
            }
            else if (e.getSource () != a2)
            {
                lives = lives - 1;
                frame2.setVisible (false);
            }

        }