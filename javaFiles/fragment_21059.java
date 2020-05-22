class MyUI extends BasicScrollBarUI
{
    @Override
    protected void scrollByBlock(int direction)
    {
        System.out.println("scrollByBlock " + direction);
        // super.scrollByBlock(direction);
        scrollBar.setValue(scrollBar.getValue() + (direction * 10));
    }

    @Override
    protected void scrollByUnit(int direction)
    {
        System.out.println("scrollByUnit " + direction);
        // super.scrollByUnit(direction);
        scrollBar.setValue(scrollBar.getValue() + (direction * 3));
    }
}