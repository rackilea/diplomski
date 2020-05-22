String[] alphabet = { "a", "b", "c", "d", "e", "f", "g",
"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
"u", "v", "w", "x", "y", "z" };
final int amount = 26; //alphabet.size()
StringBuffer[] foo = new StringBuffer[pow(amount, n)];
long counter = 0;

public void recursion(int depth, StringBuffer actual)
{
    String a = actual.toString();
    for (int i = 0; i < amount; i++)
    {
        foo[counter++] = new StringBuffer(a + alphabet[i]);
        if (depth != 1)
            recursion(depth - 1, new StringBuffer(a + alphabet[i]));
    }
}