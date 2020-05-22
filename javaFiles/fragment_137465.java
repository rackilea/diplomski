Matcher nonSplitMatcher = nonSplitsPattern.matcher(docText);
//store all non split locations in a list of pairs
List<int[]> nonSplits = new LinkedList<int[]>();
while(nonSplitMatcher.find()){
   nonSplits.add(new int[]{nonSplitMatcher.start(), nonSplitMatcher.end()});
}