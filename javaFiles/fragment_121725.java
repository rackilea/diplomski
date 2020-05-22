public Object getValue()
{
    Object returnValue = null;
    if(this.value!=null)
        returnValue = this.value.getValue();
    return returnValue;
}