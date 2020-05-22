if (goingToUseStringObject...)
{
    // use the CharSequence overload
    i.putExtra("object", stringObject);
}
else if (goingToUseIntegerObject...)
{
    // use the int overload
    i.putExtra("object", integerObject);
}
else if (goingToUseDateObject...)
{
    // use the Serializable overload
    i.putExtra("object", dateObject);
}