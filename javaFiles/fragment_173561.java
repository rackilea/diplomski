final JFileChooser chooser = new JFileChooser( new File(".") )
{
    public void approveSelection()
    {
        if (getSelectedFile().exists())
        {
            System.out.println("Do You Want to Overwrite File?");
            return;
        }
        else
            super.approveSelection();
    }
};