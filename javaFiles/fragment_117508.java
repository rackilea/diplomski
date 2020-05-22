long high = 0x40_00L;
long low = 0x9e_06_52_14_1e_f0_db_f6L;
long e = (((high & 0x7FFFL) - 16383) + 1023) & 0x7FFL;
long ld = ((high & 0x8000L) << 48)
          | (e << 52)
          | ((low >>> 11) & 0xF_FFFF_FFFF_FFFFL);
System.out.printf("%16X\n", ld);
double d = Double.longBitsToDouble(ld);
System.out.println(d);