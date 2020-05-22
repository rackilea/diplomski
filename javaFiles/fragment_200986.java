Github github = new RtGithub(
                 new RtGithub("yourUsername", "yourPassword")
                 .entry()
                 .through(RetryWire.class)
 );

 Repo repo = github.repos().get(
 new Coordinates.Simple("sebenalern/database_project"));
 Issues issues = repo.issues();
 Issue issue = issues.create("issue title", "issue body");
 issue.comments().post("issue comment");