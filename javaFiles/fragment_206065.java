final CharBuffer buf = CharBuffer.wrap(input);

int maxSuccessive = 0;
int successive = 0;
char prev = buf.get();
char next;

while (buf.hasRemaining()) {
    next = buf.get();
    if (next - prev == 1)
        successive++;
    else {
        maxSuccessive = Math.max(maxSuccessive, successive);
        successive = 0;
    }
    prev = next;
}

// test maxSuccessive