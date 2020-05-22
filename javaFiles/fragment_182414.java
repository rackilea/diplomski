void serialEvent(Serial port) {
    println(port.read());
    volume = map(port.read(),0,255,0.0,1.0);
    println(volume);
    delay(200);
}