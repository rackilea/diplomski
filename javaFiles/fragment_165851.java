byte unsignedA = 0;
unsignedA--; 
// unsignedA == FF, is this -1 or 255? Java assumes the former but you assume the later

byte unsignedB = unsignedA * unsignedA;
// unsignedB is -1 * -1 = 1 or (byte) (255*255) = (byte) 65525 = 1.