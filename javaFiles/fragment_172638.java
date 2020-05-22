public static void main(String[] args)
{
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\test.txt")))
    {
        String line;
        List<List<Character>> lines = new ArrayList<>();

        int longestLine = 0;
        while((line = br.readLine()) !=null)
        {
            line = line.trim();

            if (line.length() > 0)
            {
                List<Character> currList = new ArrayList<>();
                for (char c : line.toCharArray())
                {
                    currList.add(c);
                }

                if (currList.size() > longestLine)
                {
                    longestLine = currList.size();
                }

                lines.add(currList);
            }
        }

        // pad all lists to be the same as the longest
        for (List<Character> currList : lines)
        {
            while (currList.size() < longestLine)
            {
                currList.add(Character.MIN_VALUE);
            }
        }

        // go through each list backwards
        for (int i = longestLine - 1; i >= 0; i-- )
        {
            for (List<Character> currList : lines)
            {
                System.out.print(currList.get(i));
            }
            System.out.println();
        }
    }
    catch (Throwable t)
    {
        t.printStackTrace();
    }
}