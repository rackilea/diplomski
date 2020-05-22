List<String> revertedCommits = new ArrayList<>();
revertedCommits.add(<commitID>);
String revertedCommit = "unknown";
Map<String, RevisionInfo> revisionInfo = gerritClient.changes().query("commit:" + revertedCommits.get(revertedCommits.size() - 1) + "&o=CURRENT_REVISION&o=COMMIT_FOOTERS").get().get(0).revisions;
Pattern p = Pattern.compile(Pattern.quote("This reverts commit ") + "(.*?)" + Pattern.quote("."));
Matcher m = p.matcher(revisionInfo.values().iterator().next().commitWithFooters);
while (m.find()) {
    revertedCommit = m.group(1);
}