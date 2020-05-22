final Text textField = new Text(shell, SWT.BORDER);
textField.addListener(SWT.Verify, new Listener() {
    @Override
    public void handleEvent(Event e) {
        // You can access textField, since it is final
        final String oldS = textField.getText();
        String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);

        boolean isValid = true;

        if("".equals(newS))
        {
        }
        else
        {
            try
            {
                // first check, if text really is a number
                float value = Float.parseFloat(newS);

                // then check if it's between 0 and 100
                if(value < 0 || 100 < value)
                    isValid = false;
            }
            catch(NumberFormatException ex)
            {
                isValid = false;
            }
        }

        // if text is not a valid number, prevent user input
        if(!isValid)
            e.doit = false;
    }
});