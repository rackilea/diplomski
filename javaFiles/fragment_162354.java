float lerp(byte x1, byte x2, float a) {

return unsignedByteToInt(x1) * (1 - a) + unsignedByteToInt(x2) * a;

}

int unsignedByteToInt(byte x) {return (((int) x) + 255) % 255;}