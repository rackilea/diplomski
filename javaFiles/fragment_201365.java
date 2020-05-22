try {
        spinner.commitEdit();
    }
    catch (ParseException pe) {{
        // Edited value is invalid, spinner.getValue() will return
        // the last valid value, you could revert the spinner to show that:
        JComponent editor = spinner.getEditor()
        if (editor instanceof DefaultEditor) {
            ((DefaultEditor)editor).getTextField().setValue(spinner.getValue());
        }
        // reset the value to some known value:
        spinner.setValue(fallbackValue);
        // or treat the last valid value as the current, in which
        // case you don't need to do anything.
    }
    int value = (Integer)spinner.getValue();