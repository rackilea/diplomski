static int n = 0;
static String keyword = "aabc";
static String[] words = null;
public static void main()
{
    n = 0;
    // Let's assume you accept 'k' here.
    String YourString = "aabc baca hjfg gabac";
    words = YourString.split(" ");
    rec(words[0]);
    if (k <= n)
        System.out.println(true);
    else
        System.out.println(false);
}
static int pos = 0;
public static void rec(String word)
{
    boolean flag = true;

    word += " ";

    if(word.length() != keyword.length() + 1)
    {
        flag = false;
    }

    for(int i = 0; i < keyword.length() && flag; i++)
    {
        for(int j = 0; j < word.length(); j++)
        {
            if(word.charAt(j) == keyword.charAt(i))
            {
                word = word.substring(0, j) + word.substring(j+1);
                break;
            }
        }
        if(word.equals(" "))
        {
            n++;
            break;
        }
    }

    if(pos + 1 != words.length)
    {
        rec(words[++pos]);
    }
}