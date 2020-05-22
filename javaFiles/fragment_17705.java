boolean isWinner(JButton buttons[], String player)
{
    for (int i = 0; i < 3; i++)
    {
        if (buttons[i].getActionCommand().equals(player) &&
                buttons[i + 3].getActionCommand().equals(player) &&
                buttons[i + 6].getActionCommand().equals(player))
        {
            return true;
        }
    }

    for (int i = 0; i < 9; i += 3)
        if (buttons[i].getActionCommand().equals(player) &&
                buttons[i + 1].getActionCommand().equals(player) &&
                buttons[i + 2].getActionCommand().equals(player))
        {
            return true;
        }

    if (buttons[0].getActionCommand().equals(player) &&
            buttons[4].getActionCommand().equals(player) &&
            buttons[8].getActionCommand().equals(player))
    {
        return true;
    }

    return buttons[2].getActionCommand().equals(player) &&
            buttons[4].getActionCommand().equals(player) &&
            buttons[6].getActionCommand().equals(player);
}