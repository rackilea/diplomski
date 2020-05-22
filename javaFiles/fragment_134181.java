for (int v = 0; v < random.length(); v++) {
      if (guess2 == random.charAt(v)) {
           newDisplaySecret += random.charAt(v); // newly guessed
                                                 // character
        } else {
           newDisplaySecret += displaySecret.charAt(v);
}