int x = (int) Math.floor(j/2^16);
int y = (int) Math.floor((j-(x*65536))/2^8);
int z = (int) Math.floor(j-((x*2^16)+(y*2^8)));

x = 2nd character
y = 3rd character
z = 4th character