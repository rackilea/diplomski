float x = 24.801044f;
float y = 120.993085f;
System.out.println("Input: "+x+"; "+y);
// Encode
long data = (((long)Float.floatToRawIntBits(x)) << 32) | Float.floatToRawIntBits(y);
// Now send the data to another phone
// Decode
float resX = Float.intBitsToFloat((int)(data >>> 32));
float resY = Float.intBitsToFloat((int)data);
System.out.println("Result: "+resX+"; "+resY);