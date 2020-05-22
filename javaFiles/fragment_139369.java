for (int buttonPressed = 0; buttonPressed < outputBoxButtonsPressed.length; buttonPressed++) {
    if (outputBoxButtonsPressed[buttonPressed + 1].equals("+")) {
        answer = Integer
            .parseInt(outputBoxButtonsPressed[buttonPressed])
             + Integer
                 .parseInt(outputBoxButtonsPressed[buttonPressed + 2]); //here
        break;
    }
 }