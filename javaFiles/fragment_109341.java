File file = new File("text.txt");
if (file.exists())
{
    if (!file.delete())
    {
        JOptionPane.showMessageDialog(null, "File was not deleted");
    }
    else
    {
        JOptionPane.showMessageDialog(null, "File was deleted");
    }
}
else
{
    JOptionPane.showMessageDialog(null, "File does not exist");
}