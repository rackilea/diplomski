// encapsulate this into a class and do once; perhaps use a static initializer
boolean[] allowed = new boolean[256]; // default false
allowed[32] = true;
allowed['a'] = true;
// fill all allowed characters
allowed['Z'] = true;

// the check
for (int n=0,len=str.length(); n<len; n++) {
  char ch = str.charAt(n);
  if (ch>255 || !allowed[ch]) {
    return false;
  }
}
return true;