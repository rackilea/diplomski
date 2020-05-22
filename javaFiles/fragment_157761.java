FileOutputStream out = null;
try {
  out = ...
  ...
  out.write(...);
  ...
  out.flush();
} catch (IOException ioe) {
  ...
} finally {
  if(out!=null) {
    try {
      out.close();
    } catch (IOException ioe) {
      ...
    }
  }
}