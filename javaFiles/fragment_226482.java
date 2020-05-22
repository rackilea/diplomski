ArrayList<JLabel> labels = new ArrayList<JLabel>();
StringTokenizer tokenizer = new StringTokenizer(str, "$");

while(tokenizer.hasMoreTokens()){
 labels.add(new JLabel(tokenizer.nextToken()));
}

JPanel p = new JPanel();
for(int =0; i<labels.size(); i++)
{
 p.add(labels.get(i));
}
...