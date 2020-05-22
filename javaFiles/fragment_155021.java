public void yourValueChangeListener(ValueChangeEvent event)
{
    if(event.getNewValue() == null)
        return;

    if((Integer)event.getNewValue() ==  1)
    {
        //react on a change to 1
    }
    if((Integer)event.getNewValue() ==  0)
    {
        //react on a change to 0
    }
}
public int getYourIntValue() {
    return yourIntValue;
}

public void setYourIntValue(int yourIntValue) {
    this.yourIntValue = yourIntValue;
}