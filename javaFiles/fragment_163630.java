yourComponent.addMouseListener(new CustomMouseListener());

class CustomMouseListener implements MouseListener
{
    @Override
    public void mouseClicked(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e)
    {
        //Mouse is over component
        Object source = e.getSource();
        if (source instanceof JButton) {
            System.out.println("Mouse is over a JButton");
        }

        if (source instanceof JTextField) {
            System.out.println("Mouse is over a JTextField");
        }

        if (source instanceof JLabel) {
            System.out.println("Mouse is over a JLabel");
        }

        Sysem.out.println("Mouse is over "+ e.getComponent().getClass().getName());
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
         //Mouse is not over component
         Sysem.out.println("Mouse is not over "+ e.getComponent().getClass().getName()+" anymore");
    }

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}
}