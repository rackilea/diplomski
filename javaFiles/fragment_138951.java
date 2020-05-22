public static void main(String[] args)
{
    String[] matches = { "a", "b", "c" };
    String[] visibleObjects = { "c", "d", "e" };
    String target = null;

    firstLoop: for (String word : matches)
    {
        for (String hint : visibleObjects)
        {
            if (word.equals(hint))
            {
                target = word;
                break firstLoop;
            }
        }
    }

    System.out.println(target);
}