private static final HashMap<String, Integer> NUMS = new HashMap<String, Integer>();

static
{
    NUMS.put("zero", 0);
    NUMS.put("one", 1);
    NUMS.put("two", 2);
    NUMS.put("three", 3);
}

private static int findANumber(final String partOfaNumber) throws IllegalArgumentException
{
    int multiplicand = 0;  
    final Integer theNum = NUM.get(partOfaNumber);
    if (theNum != null) {
        multiplicand += theNum;
    } else {
        throw new IllegalArgumentException("Number not found (" + partOfNumber + ")");
    }

    return multiplicand;
}