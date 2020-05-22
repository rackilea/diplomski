final JButton finalButton = button; // this is your button will trigger download
final JLabel finalLabel = finalLabel;
final JTable finalTable = table;


if(ae.getActionCommand().equals("Download"))
{
    finalButton.setEnabled(false); //disable button, so user can not start it for twice until ftp finished.
    Thread thread = new Thread(new Runnable()
    {
        @Override
        public void run()
        {
            int[] row_indexes = finalTable.getSelectedRows();

            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    finalLabel.setText("Downloading files");
                }
            });

            for(int i = 0; i < row_indexes.length; i++)
            {
                final String fn = finalTable.getValueAt(row_indexes[i], 0).toString();

                SwingUtilities.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        finalLabel.setText("Downloading: " + fn);  // fn contains filename
                    }
                });

                this.downloadFtpfile(fn);
            }

            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    finalLabel.setText("SUCCESSFULLY DOWNLOADED FILE(s) !");
                    finalButton.setEnabled(true); //enable the button
                }
            });
        }
    });
    thread.start();
};