for(int i = 0; i< 5; i++)
{
    oneDword.add(words[i]);
    twoDWords.add(oneDword);
    oneDword = new ArrayList<String>(); // --> You need this since 'oneDword' contains the previous values as well and it'll keep adding new values to this list.
    //oneDword.clear();
}

for(List<String> al: twoDWords) {
  for(String s: al) {
    System.out.println(s);
  }
}