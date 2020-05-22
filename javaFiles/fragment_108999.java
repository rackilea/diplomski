Point location = MouseInfo.getPointerInfo().getLocation();
Component button = e.getComponent();
JPanel parent = (JPanel)button.getParent();
SwingUtilities.convertPointFromScreen(location, parent);
Component mouseOver = parent.findComponentAt( location );

if (mouseOver instanceof JToggleButton)
{
    JToggleButton button = (JToggleButton)mouseOver;
    button.setBackground( Color.YELLOW );
}