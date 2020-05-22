long l = 123;
int size = (int)(Math.log10(l)+1);
byte[] array = new byte[size];
for (int i = 0; i < size; i++) {
    long temp = (long) Math.pow(10, size - i - 1);
    array[i] = (byte) ((l / temp) + 48);
    l = l % temp;
}
System.out.println(Arrays.toString(array)); // [49, 50, 51]