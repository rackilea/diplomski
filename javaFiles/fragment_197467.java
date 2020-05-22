String buttonText = e.getActionCommand();
switch(buttonText)
{
    case IconNames.ButtonFett_CMD: // user language independent
        replace(XmlTags.BOLD);
        break;
}