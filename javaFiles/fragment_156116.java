protected Integer skipLine(byte[] buf,Integer len, Integer i) {
    return IntStream.range(i, len)
                    .filter(n -> buf[n] == '\n')
                    .peek(n -> newLine())
                    .findFirst()
                    .orElse(len-1) + 1;
}