JFileChooser chooser = new JFileChooser( new File(".") )
{
    public void approveSelection()
    {
        if (getSelectedFile().exists())
        {
            System.out.println("duplicate");
            return;
        }
        else
            super.approveSelection();
    }
};