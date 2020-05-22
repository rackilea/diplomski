if (ke.getKeyCode() == 38) // '^ key'
        {
            if (key == NONE)
                {
                    held = false;
                    timeHeld = 0;
                }
            key = UP;
            return;
    }