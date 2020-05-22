String b = "110011110001111111111111";

int decimal=Integer.parseInt(b,2);

String t = Integer.toHexString(decimal);

byte[] bval = t.getBytes();