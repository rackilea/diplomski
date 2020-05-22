// Poor
char[] inputBuffer = new char[1024];
fIn = _context.openFileInput(sFileName);
isr = new InputStreamReader(fIn);

// Better
long nbytes = new File(sFileName).length();
char[] inputBuffer new char[nbytes];
isr = new InputStreamReader (
  _context.openFileInput (sFileName));