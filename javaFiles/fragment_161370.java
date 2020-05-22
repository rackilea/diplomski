BufferedReader buf = new BufferedReader(isr);
// remove BOM
buf.mark(1);
if(buf.read() != '\uFEFF') {
  buf.reset();
}
// continue...