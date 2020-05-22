void serialEvent(Serial port) {
    println(port.read());
    volume = port.read() / 255.0;
    println(volume);
    delay(200);
}