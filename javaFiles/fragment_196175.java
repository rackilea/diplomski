@Override
    public void internalFrameIconified(InternalFrameEvent arg0)
    {
        System.out.println("Disabling "+save);
        save.setEnabled(false);
    }