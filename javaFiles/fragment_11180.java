spinner.addChangeListener(new ChangeListener()
{
    @Override
    public void stateChanged(ChangeEvent arg0)
    {
        final JScrollBar vertical = scroll_pane.getVerticalScrollBar();
        final int value = vertical.getValue();

        text1.setText(spinner.getValue().toString());
        text2.setText(spinner.getValue().toString());
        text3.setText(spinner.getValue().toString());
        text4.setText(spinner.getValue().toString());
        text5.setText(spinner.getValue().toString());
        text6.setText(spinner.getValue().toString());
        text7.setText(spinner.getValue().toString());

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                vertical.setValue( value );
            }
        });
    }
});