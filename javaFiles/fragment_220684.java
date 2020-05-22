List<MyWord>secondList = new ArrayList<MyWord>();
for(int i=0;i<firstList.size();i++)
{
 String[]words = firstList.get(i).split("\\s");
 for(String wordToAdd : words)
 {
  MyWord w = new MyWord(i,wordToAdd);
  secondList.add(w);
 }
}