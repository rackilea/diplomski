int[] add = new int[256];
int[] xor = new int[256];

for (int i = 0; i < 256; i++)
    for (int j = 0; j < 256; j++) {
        add[(i + j) & 0xFF]++;
        xor[i ^ j]++;
    }

System.out.println("add: " + Arrays.toString(add));
System.out.println("xor: " + Arrays.toString(xor));