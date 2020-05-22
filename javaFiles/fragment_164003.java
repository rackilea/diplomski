private static final int PATTERN_LENGTH = 24;
....

List<Location> list = new ArrayList<Location>();

if (text.length() % PATTERN_LENGTH != 0)
{
    // throw an exception of some description; you haven't got valid data
}
for (int start = 0; start < text.length(); start += PATTERN_LENGTH)
{
    list.add(Location.parse(text.substring(start, start + PATTERN_LENGTH));
}