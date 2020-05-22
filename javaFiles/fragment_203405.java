String pattern = "^\\{RepositoryName:\\s(.*?),RepositoryId:\\s(.*?)\\}$";
String asd = "{RepositoryName: CodeCommitTest,RepositoryId: 425f5fc5-18d8-4ae5-b1a8-55eb9cf72bef}";
String reponame = "";
String repoID = "";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(asd);
if (m.find()) {
    reponame = m.group(1);
    repoID = m.group(2);
    System.out.println("Found reponame: " + reponame + " with repoID: " + repoID);
} else {
    System.out.println("NO MATCH");
}