JLabel label = null;

    if (color.equals(Color.green))
    {
        label = new JLabel(text)
        {
            @Override
            public boolean contains(int x, int y)
            {
                return false;
            }
        };
    }
    else
        label = new JLabel(text);

    //JLabel label = new JLabel(text);