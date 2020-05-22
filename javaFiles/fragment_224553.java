int ind=0;
for(i=0 to numberTracker.size()-1) {
  String s=numberTracker.get(i);
  Color nextColor=....
  for(j=0 to s.length()-1) { tile(ind).setColor(nextColor); ind++; }
}