JFileChooser chooser = new JFileChooser( new File(".") )
{
    public void approveSelection()
    {
        if (getSelectedFile().isFile())
        {
            // beep
            return;
        }
        else
            super.approveSelection();
    }
};