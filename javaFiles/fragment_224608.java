@Test public void shouldFixBrokenStream() {
  BitReader bitReader = new StreamBitReader(BitWriter.create()
      .pushBits(16, 0x8080)
      .pushBits(12, 0x000)   // invalid 12-bit sequence
      .pushBits(16, 0x8080)
      .asByteArrayInputStream());
  BitStreamFixer fixer = new BitStreamFixer(bitReader);
  assertEquals(0x80808080, fixer.read(32));
}

/** Of course, you could skip the BitReader yourself, and just make a new one. */
@Test public void shouldFixBrokenStream_bitReader() {
  BitReader bitReader = new InMemoryBitReader();
  bitReader.pushBits(16, 0x8080);
  bitReader.pushBits(12, 0x000);   // invalid 12-bit sequence
  bitReader.pushBits(16, 0x8080);

  BitStreamFixer fixer = new BitStreamFixer(bitReader);
  assertEquals(0x80808080, fixer.read(32));
}