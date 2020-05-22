table = new JTable(new CustomModel(columnNames, values))
{
    /*
    I have omitted the other functions I have overridden here as they are not necessary for the
    solution*/

    @Override
    public void changeSelection(int row, int col, boolean toggle, boolean extend)
    {
        if(col == 1 && table.getModel().getValueAt(row, 0).equals("image"))
        {
            /*
            imageChooser is the name of the JFileChooser I am using, and I am passing the
            main frame of my application to centre the window that appears
            */
            int returned = imageChooser.showOpenDialog(frame);

            if(returned == JFileChooser.APPROVE_OPTION)
                table.getModel().setValueAt(imageChooser.getSelectedFile().getName(), row, col);
        }

        super.changeSelection(row, col, toggle, extend);
    }
}