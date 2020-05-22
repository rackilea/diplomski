String[] ss = {
    "123 SUNNYSIDE AVENUE BROOKLYN",
    "59 MAIDEN LANE MANHATTAN",
    "59 MAIDEN LANE MANHATTAN 10038",
    "39-076 46 STREET SUNNYSIDE",
    "39-076 46 STREET SUNNYSIDE 11104",
    "59 MAIDEN LANE MANHATTAN NY USA"
};

Pattern p = Pattern.compile("^(\\S+(?:\\s+\\S+)*)\\s+(MANHATTAN|BROOKLYN|SUNNYSIDE)");
Matcher m = p.matcher("");

for (String s : ss)
{
  if (m.reset(s).find())
  {
    System.out.printf("%naddr: '%s'%ncity: '%s'%n", m.group(1), m.group(2));
  }
}