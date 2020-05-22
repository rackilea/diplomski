String value = "";
// Lines of code
if (e.getSource() == numberButton1)
{
    value += "1";
}
if (e.getSource() == dotButton)
{
    value += ".";
}
// Do the same for other numbers
// When you need the value as a double do the following
double _value = Double.parseDouble(value);