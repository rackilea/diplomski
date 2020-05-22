Random rng = new Random(key);
while (scan.hasNextLine())
{
    String s = scan.nextLine();
    for (int i = 0; i < s.length(); i++)
    {
        char allChars = s.charAt(i);
        int randomNum = rng.nextInt(256);
        int cipherNums = allChars ^ randomNum;
        System.out.print(cipherNums + " ");
    }
}