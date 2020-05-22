mainFrame.addComponentListener(new ComponentListener()
    {
        @Override
        public void componentMoved(ComponentEvent evt)
        {
            GraphicsConfiguration conf = mainFrame.getGraphicsConfiguration();
            GraphicsDevice curDisplay = conf.getDevice();
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

            GraphicsDevice[] allDisplays = env.getScreenDevices();
            for (int i = 0; i < allDisplays.length; i++)
            {
                if (allDisplays[i].equals(curDisplay))
                {
                    //the window has been dragged to another display
                    if (i != _currentDisplayIndex)
                    {
                        final Rectangle sb = conf.getBounds();

                        mainFrame.setVisible(false);
                        //it is important to set the bounds somewhere on the new display before setting the extended state to maximized
                        mainFrame.setBounds(sb.x, sb.y, 1000, 800);
                        mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
                        mainFrame.setVisible(true);

                        _currentDisplayIndex = i;
                    }
                }
            }

        }

        @Override
        public void componentShown(ComponentEvent evt)
        {
        }

        @Override
        public void componentResized(ComponentEvent evt)
        {
        }

        @Override
        public void componentHidden(ComponentEvent evt)
        {
        }
    });