bytes[i * 2] = (byte) (sData[i] & 0x00FF);
=
bytes[i * 2] = (byte) (0011001101010101 & 0000000011111111);
=
bytes[i * 2] = (byte) (0000000001010101); //lower 8 bit



bytes[(i * 2) + 1] = (byte) (sData[i] >> 8);
=
bytes[(i * 2) + 1] = (byte) (0011001101010101 >> 8); //Right shift by 8 spaces
=
bytes[(i * 2) + 1] = (byte) (0000000000110011); //upper 8 bit