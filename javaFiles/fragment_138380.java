int length = mSounds.size(); // get the length of mSounds object
String[] names = new String[length]; // creates a fixed array with strings
for(int i = 0; i < length; i++) {
     // add sound name to string array
     names[i] = mSounds.get(i).getDescription(); // returns the string name
}