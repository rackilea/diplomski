public class BooleanArray32 {
  private int values;

  public boolean get(int pos) {
    return (values & (1 << pos)) != 0;
  }

  public void set(int pos, boolean value) {
     int mask = 1 << pos;
     values = (values & ~mask) | (value ? mask : 0);
  }

  public void write(DataOutputStream dos) throws IOException {
    dos.writeInt(values);
  }

  public void read(DataInputStream dis) throws IOException {
    values = dis.readInt();
  }

  public int compare(BooleanArray32 b2) {
     return countBits(b2.values & values);
  }

  // From http://graphics.stanford.edu/~seander/bithacks.html
  // Disclaimer: I did not fully double check whether this works for Java's signed ints
  public static int countBits(int v) {
    v = v - ((v >>> 1) & 0x55555555);                    // reuse input as temporary
    v = (v & 0x33333333) + ((v >>> 2) & 0x33333333);     // temp
    return ((v + (v >>> 4) & 0xF0F0F0F) * 0x1010101) >>> 24; 
  }
}