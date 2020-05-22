public void addText(String text)
{
    HashMap<String, AttributeSet> attributes = new HashMap<String, AttributeSet>();
    attributes.put("0", black);
    attributes.put("1", blue);

    String[] lines = text.split("%");

    for (int i = 1; i < lines.length; i++)
    {
        String line = lines[i];
        String key = line.substring(0, 1);
        String theText = line.substring(1);
        AttributeSet attribute = attributes.get(key);

        try
        {
            int len = doc.getLength();
            doc.insertString(len, theText, attribute);
        }
        catch (BadLocationException e)
        {
            e.printStackTrace();
        }
    }
}