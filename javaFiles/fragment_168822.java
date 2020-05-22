public class InputStreamDecorator extends InputStream {
   public InputStreamDecorator(InputStream is, long toSkip) {
      this.internalStream = is;
      is.skip(toSkip);
   }
}