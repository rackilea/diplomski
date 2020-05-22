public void controlMoved(ControlEvent e)
{
    Runnable r = new Runnable()
    {
        @Override
        public void run()
        {
           updatePreview();
        }
    };
    Display.getDefault().asyncExec(r);
}