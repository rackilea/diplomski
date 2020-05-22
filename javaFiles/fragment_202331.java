String s;// your string to split
int size;// the size of the substrings (last String may be shorter)

String[] array=new String[(s.length()+size-1)/size];
for(int ix=0, pos=0; ix<array.length; ix++, pos+=size)
  array[ix]=s.substring(pos, Math.min(s.length(), pos+size));