bt1.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v)
    {
        ArrayList<Character> charArray1 = new ArrayList<Character>();
        ArrayList<Character> charArray2 = new ArrayList<Character>();

        for (char character : st1.toString().toCharArray())
        {
            charArray1.add(character);
        }

        for (char character : st2.toString().toCharArray())
        {
            charArray2.add(character);
        }

        for (Character character : charArray2)
        {
            if (charArray1.contains(character))
                p++;
        }

        Toast.makeText(PlayActivity.this, "" + p, Toast.LENGTH_LONG).show();

    }

});