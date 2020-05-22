Random rng = new Random(key);
int randomNum = rng.nextInt(256);
while (scan.hasNextLine())
{
    String s = scan.nextLine();
    for (int i = 0; i < s.length(); i++)
    {
        char allChars = s.charAt(i);
        int cipherNums = allChars ^ randomNum;
        System.out.print(cipherNums + " ");
    }
}