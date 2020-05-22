public final StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition fieldPosition)
{
    if (obj instanceof Date)
        return format( (Date)obj, toAppendTo, fieldPosition );
    else if (obj instanceof Number)
        return format( new Date(((Number)obj).longValue()), toAppendTo, fieldPosition );
    else
        throw new IllegalArgumentException("Cannot format given Object as a Date");
}