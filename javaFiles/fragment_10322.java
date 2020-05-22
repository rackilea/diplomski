for(int x = 0; x < 3; x++)
    {
        for(int y = 0; y < 3; y++)
        {
            row.addView(buttons[count]);
            count++;
        }
        table.addView(row, x);
    }