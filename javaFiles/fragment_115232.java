reflectPrimitiveNumericArray(new byte[] { (byte) 0xF0 });
// byte[1] = { 11110000 }
reflectPrimitiveNumericArray(new int[] { 0xF0F0F0F0 });
// int[1] = { 11110000111100001111000011110000 }
reflectPrimitiveNumericArray(new long[] { 0xF0F0F0F0F0F0F0F0L });
// long[1] = { 1111000011110000111100001111000011110000111100001111000011110000 }