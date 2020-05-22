/**
        * Prints a String and then terminate the line.  This method behaves as
        * though it invokes <code>{@link #print(String)}</code> and then
        * <code>{@link #println()}</code>.
        *
        * @param x  The <code>String</code> to be printed.
        */

       public void println(String x) {
           synchronized (this) {
               print(x);
               newLine();
           }
      }