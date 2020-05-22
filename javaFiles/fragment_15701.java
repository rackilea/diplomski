String[] subs = new String[input.length()/3];
int index;
for (int i=0; i<input.length(); i++) {
    index = i*3;
    subs[i] = input.substring(index, index+3);
}