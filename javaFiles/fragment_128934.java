public static int clamp(int value, int min, int max)
{
   return value < min ? min : value > max ? max : value;
}

public int compareTo(Parent other)
{
    int clampedSeverity = clamp(this.severity, 1, 17);
    int clampedOtherSeverity = clamp(this.severity, 1, 17);
    //do comparisons
}