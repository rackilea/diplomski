JPanel subPanel = new JPanel()
{
    @Override
    public int getBaseline(int width, int height)
    {
        Component c = getComponent(0);
        return c.getBaseline(width, height);
    }
};