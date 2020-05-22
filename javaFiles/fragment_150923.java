public void setNewValue(String newVal)
{
    if(!newVal.equals(currentVal)) {
        currentVal = newVal;
        // Value has changed. Call the relevant code.
    }
}