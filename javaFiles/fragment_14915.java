import org.apache.commons.lang.StringUtils;

...

else if(event.getSource() == backspace)
{
    if(!display.getText().isEmpty())
        display.setText(StringUtils.chop(display.getText()));
}