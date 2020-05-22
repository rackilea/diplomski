HashingStrategy<String> caseInsensitive = new HashingStrategy<String>()
{
    @Override
    public int computeHashCode(String string)
    {
        int hashCode = 0;
        for (int i = 0; i < string.length(); i++)
        {
            hashCode = 31 * hashCode + Character.toLowerCase(string.charAt(i));
        }
        return hashCode;
    }

    @Override
    public boolean equals(String string1, String string2)
    {
        return string1.equalsIgnoreCase(string2);
    }
};

assertThat(
    strings.distinct(caseInsensitive),
    is(equalTo(Lists.immutable.with("Hello", "world"))));