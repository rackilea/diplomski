try {
    /*
     * Try to create a new joystick.
     */
    Joystick joystick = new Joystick();

    try {
        /*
         * Set joystick values
         */

        /*
         * Set analog values for Axis X/Y/Z,
         * Rotation X/Y/Z, Slider, Dial. Overall 8 axes.
         * 
         * Here we set the Z Axis to maximum.
         */
        joystick.analog[Joystick.ANALOG_AXIS_Z] = Joystick.ANALOG_MAX;

        /*
         * Set digital values for the buttons. Overall 16 buttons.
         *
         * Here we turn on the 13-th button
         */
        joystick.digital[12] = Joystick.DIGITAL_ON;

        /*
         * Send the data to the joystick. Keep in mind,
         * that the send method may throw a JoystickException
         */
        joystick.send();
    } finally {
        joystick.close();
    }
} catch (JoystickException e) {
    e.printStackTrace();
}