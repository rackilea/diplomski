try
{
    Robot mouseHandler = new Robot();

    int mouseButtonNum = 4; // 1 - 20
                            // but only buttons from 1 to 5 did work with Robot

    mouseHandler.mousePress(MouseEvent.getMaskForButton(mouseButtonNum));
    mouseHandler.mouseRelease(MouseEvent.getMaskForButton(mouseButtonNum));
} catch (AWTException e)
{
    e.printStackTrace();
}