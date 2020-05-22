public static void main(String []args)
 {
    ArrayList<Character> charOutput = new ArrayList<Character>();
    ArrayList<Character> charOutputTrimmed = new ArrayList<Character>();
    charOutput.add('0');charOutput.add('0');charOutput.add('0');
    charOutput.add('1');charOutput.add('1');charOutput.add('1');
    charOutput.add('*');charOutput.add('*');charOutput.add('2');
    charOutput.add('2');charOutput.add('0');

    Character currentChar = charOutput.get(0);
    charOutputTrimmed.add(currentChar);
    for(int i=1;i<charOutput.size();i++)
    {
        if(currentChar != charOutput.get(i))
        {
            currentChar = charOutput.get(i);
            charOutputTrimmed.add(currentChar);
        }
    }

    for(int i=0;i<charOutputTrimmed.size();i++)
    {
        System.out.print(charOutputTrimmed.get(i) + "\t");
    }
 }