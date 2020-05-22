int pos = s.indexOf("name");
int spaceCount = 0;
for (int i = pos -1; i >= 0 && s.charAt(i) == ' '; i--) {  
    spaceCount ++;
}
// number of spaces: spaceCount