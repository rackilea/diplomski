OutputStream out = System.out;
byte[] buffer = new byte[n*11];
int position = buffer.length;
for (int i = n - 1; i >= 0; i--) {
    int number = a[i];
    buffer[--position] = '\n';
    do {
        buffer[--position] = (byte) ('0' + number % 10);
        number /= 10;
    } while (number != 0);
}
out.write(buffer, position, buffer.length - position);