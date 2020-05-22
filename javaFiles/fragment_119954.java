Map<char, boolean> letters = new HashMap<String,boolean>
String uline = line.toUpperCase();

for (int i=0, i < uline.length; i++) {
    letters.put(uline.charAt(i), true );
}


boolean allChars = true;
for (char c='A'; c<='Z'; c++) {
if (letters.get(c) == null) {
   allChars = false;
   break;
}