757 public void println(char x[]) {
758     synchronized (this) {
759         print(x);
760         newLine();
761     }
762 }