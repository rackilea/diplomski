for (int i = 0; i < hand.length(); i++) 
    {
        if (i == 0) {
            x = hand.charAt(0);
        } else if (x == hand.charAt(i)) {
            counter++;
        }
    }