if (ke.getKeyCode() == 38) // '^ key'
    {
        if (key == NONE && delay == 0)
                {
                    held = false;
                        timeHeld = 0;
                }
            key = UP;
            return;
        }