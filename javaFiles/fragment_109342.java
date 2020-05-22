try
{
    BufferedWriter out = new BufferedWriter(new FileWriter("text.txt",true));
    try
    {
        String word = tf.getText()+ " ";
        out.append(word);
        tf.setText("");
    }
    finally
    {
        try
        {
            out.close();
        }
        catch (IOException ex)
        {
            // Report close failure.
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
catch (Exception ex)
{
    // Report open or write failure.
    JOptionPane.showMessageDialog(null,ex.getMessage());
}