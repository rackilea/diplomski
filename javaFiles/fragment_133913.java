final TextArea area = new TextArea();
area.addKeyDownHandler(new KeyDownHandler()
{
    @Override
    public void onKeyDown(KeyDownEvent event)
    {
        // Check if ctrl is pressed

        int position = area.getCursorPos();

        if(position > 0)
            System.out.println(area.getText().toCharArray()[position - 1]);
    }
});