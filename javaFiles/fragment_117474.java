public String formatNumber(BigInteger value)
{
  // Initialize suffixes
  String[] suffixes = new String[]{null, 'k', 'M', ....};

  // Initialize divider
  BigInteger thousand;
  thousand = new BigInteger(1000);

  // Initialize divisions
  BigInteger final_value;
  BigInteger remainder;
  int        nr_divisions;
  final_value = value;
  remainder = null;
  nr_divisions = 0;

  // Divide until final value less then 1000
  BigInteger[] division;
  while (final_value.compareTo(thousand) >= 0)
  {
    division = final_value.divideAndRemainder(thousand);
    final_value = division[0];
    remainder = division[1];
    nr_divisions++;
  }

  // Maybe no divisions
  if (nr_divisions == 0)
    return (value.toString());

  // Determine suffix
  // Some check required since number of divisions may exceed the number of suffixes provided
  String suffix;
  suffix = suffixes[nr_divisions];

  // Compose string
  return (final_value.toString() + "." + String.format("%03d", remainder.intValue()) + suffix);

} // formatNumber