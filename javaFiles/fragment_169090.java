String string = "thisisastring";

StringBuffer buffer = new StringBuffer();
ArrayList<Character> chars = new ArrayList<>();
ArrayList<Integer> counts = new ArrayList<>();

for(int i= 0; i< string.length(); i++)
{
  char curChar = string.charAt(i);
  int charIndex;
  // if curChar already exists in chars, increment its count      
  if((charIndex = chars.indexOf(curChar))>-1) 
  {
    counts.set(charIndex, counts.get(charIndex)+1);
  }
  else // else add it to chars and add its count which is 1 to counts
  {
    chars.add(curChar);
    counts.add(1);
  }
}

for(int i= 0; i< chars.size(); i++)
  // if char count is odd, add it to the buffer
  if(counts.get(i)%2!=0)  
    buffer.append(Character.toString(chars.get(i)));

System.out.println(buffer.toString()); // prints hisarng