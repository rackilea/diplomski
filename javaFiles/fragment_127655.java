public static void mines(JButton[][] buttons)
{
    Random rand = new Random();
    int mineCount = 0;
    while (mineCount < 30)
    {
        int randomInteger = (int) (rand.nextDouble() * buttons.length);
        int randomInteger2 = (int) (rand.nextDouble() * buttons[0].length);
        if (buttons[randomInteger][randomInteger2].getText().equals("X"))
            continue;
        else
        {
            buttons[randomInteger][randomInteger2].setText("X");
            mineCount++;
        }
    }

}