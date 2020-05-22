void serialEvent(Serial port) {
    int arduinoValue = port.read();
    float gain = map(arduinoValue,0,255,-10.0,10.0);
    println("arduinoValue: " + arduinoValue + " gain: " + gain);
    player.setGain(gain);
}