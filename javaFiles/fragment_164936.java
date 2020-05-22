public void get_locationX(ComponentEvent e)
{
    int x = e.getComponent().getX();

    x_txt.setText(String.valueOf(x));
}