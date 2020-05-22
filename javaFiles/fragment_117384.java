public enum SizeUnit
{
  BYTE(1),
  KILOBYTE(1024),
  ...;

  private final int bytes; 
  private SizeUnit(final int bytes) { this.bytes = bytes; }
  public int getByteCount() { return this.bytes; }
}