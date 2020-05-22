public static DateTime operator -(DateTime d, TimeSpan t)
{
  //range checks
  long internalTicks = d.InternalTicks;
  long num = t._ticks;
  if (internalTicks < num || internalTicks - 3155378975999999999L > num)
    throw new ArgumentOutOfRangeException("t", 
            Environment.GetResourceString("ArgumentOutOfRange_DateArithmetic"));

    else

    //plain arithmetic using the Ticks property of the two dates.
    return new DateTime((ulong) (internalTicks - num) | d.InternalKind);
}