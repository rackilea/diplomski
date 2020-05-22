int uppers = 0;
for(char c : s.toCharArray()) {
    if(Character.isUpperCase(c)) {
        ++uppers;
    }
}
double pct = (uppers * 1D) / (s.length() * 1D) * 100D;
if(pct > 60D) {
   // do somnething
}