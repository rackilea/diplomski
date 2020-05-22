if (value.toString().equals("X"))
{
    URL test = getClass().getResource(resources/icon.png");
    setIcon(new ImageIcon(test));
    setText("");
}
else
{
    setIcon(null);
    setText(value.toString());
}