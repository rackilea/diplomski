Ordering<String> typeOrdering = Ordering.explicit("task", "bug", "story", "epic");
Ordering<IssueTest> issueTestOrdering =
 typeOrdering.onResultOf(new Function<IssueTest, String>() {
   public String apply(IssueTest it) {return it.getType(); }
 });
Collections.sort(list, issueTestOrdering);